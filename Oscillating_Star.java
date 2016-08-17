import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import hype.*; 
import hype.extended.behavior.*; 
import hype.extended.colorist.*; 
import hype.extended.layout.*; 
import hype.interfaces.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Oscillating_Star extends PApplet {
  
HColorPool colors;

public void setup() {
  
  H.init(this).background(0xff111111);
  colors = new HColorPool(0xffB26C6C, 0xff6C82B2, 0xff6CB2B0, 0xffB26E6C, 0xff311716, 0xffF2E4E3 );

  int starScale = 450;
  int starOffest = 10;

  for (int i=0; i<53; ++i) {
    HPath d = (HPath) H.add( new HPath().star(5, 0.5f, -90) )
      .size(starScale)
      .noStroke()
      .fill( colors.getColor() )
      .anchorAt(H.CENTER)
      .locAt(H.CENTER)
    ;

    new HOscillator()
      .target(d)
      .property(H.ROTATION)
      .range(-30,0)
      .speed(0.4f)
      .freq(3)
      .currentStep(i)
    ;

    starScale -= starOffest;
    
  }
}

public void draw() {
  
  H.drawStage();
}
  public void settings() {  size(640, 640);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Oscillating_Star" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
