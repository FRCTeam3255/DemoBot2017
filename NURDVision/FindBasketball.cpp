#include <iostream>
#include <opencv2/opencv.hpp>
#include <networktables/NetworkTable.h>
#include <ntcore.h>
#include <cscore.h>

//namespaces so you dont have to say std:: before every line of code
using namespace std;
using namespace cv;
using namespace cs;

//constants to be used later
const int teamNumber = 3255;
const int camerainput = 1;
const int streamPort = 1180;

vector<double> Hue = {47, 96};
vector<double> Saturation = {186, 255};
vector<double> Luminance = {16, 129};

//camera and object values
const double OBJECT_AREA = 18.5;
const double OBJECT_WIDTH = 2;
const double PIXEL_AREA = 8190; 
const double BASE_DISTANCE = 36; 
const double PIXEL_WIDTH = 40;

int dilation_elem = 0;
int dilation_size = 0;
int const max_elem = 2;
int const max_kernel_size = 21;


/** Function Headers */
//color values
const Scalar SKY_BLUE = Scalar(250, 206, 135);
const Scalar RED = Scalar(0, 0, 255);
const Scalar GREEN = Scalar(0, 255, 0);
const Scalar BLUE = Scalar(255, 0, 0);
const Scalar YELLOW = Scalar(0, 255, 255);
const Scalar WHITE = Scalar(255, 255, 255);

//math to find the focal length of your camera
const double FOCAL_LENGTH = (PIXEL_WIDTH * BASE_DISTANCE)/OBJECT_WIDTH;


struct {
	bool operator() (cv::Rect a, cv::Rect b) {
		return b.area() < a.area();
	}
} boundingBoxSortDescending;


void createMask(Mat &input, Mat &mask, Mat &output) {
	mask.convertTo(mask, CV_8UC1);
	bitwise_xor(output, output, output);
	input.copyTo(output, mask);
}

void filterContours(vector<vector<Point> > &input, vector<vector<Point> > &output) {
	output.clear();
	for (vector<Point> contour : input) {
		Rect contourBounding = boundingRect(contour);
		if (contourBounding.width < 6 || contourBounding.width > 1000000) continue;
		if (contourBounding.height < 6 || contourBounding.height > 1000000) continue;
		double area = contourArea(contour);
		if (area < 50) continue;
		if (arcLength(contour, true) < 100) continue;
		output.push_back(contour);
 	}
}

// Creates contours
void createContours(Mat &input, vector<vector<Point> > &contoursOutput){
	//makes vectors to store contour information
	vector<vector<Point> > contoursInput;
	//converts our hsl filter into black and white, because findContours requires you to be using black and white, not RGB or HSL	
	cvtColor(input, input, CV_RGB2GRAY);
	//finds the contours of the image
	findContours(input, contoursInput, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_SIMPLE);
	//creates mat for the drawing of the contours
	filterContours(contoursInput, contoursOutput);
}

void findBalls(Mat &imageInput, vector<vector<Point> > &input, Mat &output){	
	//readys Output mat for contour use
	output = Mat::zeros(imageInput.size(), CV_8UC3);
	//creates Vector of Bounding Boxes
	vector<Rect> boundingBoxes(input.size());
	
	//finds all the targets
	for (int i = 0; i< input.size(); i++) {
		sort(boundingBoxes.begin(), boundingBoxes.end(), boundingBoxSortDescending); 
		//adds rectangles
		Rect contourBounding = boundingRect(input[i]);
		//stores rectangles into bounding box vector
		boundingBoxes[i] = contourBounding;
		//draws contours onto output
		drawContours(output, input, i, SKY_BLUE, 2);
		Rect target1 = boundingBoxes[0];
		
		//Draws two rectanges onto output
		rectangle(output, target1, GREEN, 2);
	}
}

void Dilation( Mat& src, Mat& output, int dilation_type, int dilation_size )
{
  dilation_type = 0;
  if( dilation_elem == 0 ){ dilation_type = MORPH_RECT; }
  else if( dilation_elem == 1 ){ dilation_type = MORPH_CROSS; }
  else if( dilation_elem == 2) { dilation_type = MORPH_ELLIPSE; }

  Mat element = getStructuringElement( dilation_type,
                       Size( 2*dilation_size + 1, 2*dilation_size+1 ),
                       Point( dilation_size, dilation_size ) );

  /// Apply the dilation operation
  dilate( src, output, element );
}



void processImage(Mat& input, Mat& erodedd, Mat& center, Mat& output,Mat& maskOutput){
	// Mats for processed outputs
	Mat contoursImageOutput, targetsOutput;
	// Create a HSL Maskv
	Dilation(input, erodedd, 2,8);
	cvtColor(erodedd, center, COLOR_BGR2HSV);
	inRange(center, Scalar(0,140,170), Scalar(11,255,255), center);
	createMask(input, center, maskOutput);
	// Vector for storing contour values
	vector<vector<Point> > contoursValueOutput;
	// Create Contours
	createContours(maskOutput, contoursValueOutput);
	
	// Finds targets and passes back distance and angle
	findBalls(maskOutput, contoursValueOutput, targetsOutput);
	output = targetsOutput;
}

bool quit(){
	char key = (char)waitKey(5);
	return( key == 27 || key == 'q' || key == 'Q' ); // key 27 = 'ESC'
}

int main(int argc, char const *argv[])
{

	Mat raw, eroded, middle, center, processed, output, masks;
	
	VideoCapture capture(camerainput);
	if (!capture.isOpened()) {
		cerr << "\n\e[31mERROR! Unable to open camera\nERROR! Is the camera connected?\e[0m\n";
		NetworkTable::Shutdown();
		return 1;
	}
	while (!quit()) {
		capture.read(raw);
		processImage(raw,eroded,center,output,masks);
		imshow("counours Processing", center);
		imshow("hsv", center);
		imshow("raw", raw);
		imshow("Raw Image", eroded);
	}
	cout << "Vision stopped successfully";
	return 0;

}