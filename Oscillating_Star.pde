import hype.*;
import hype.extended.behavior.*;
import hype.extended.colorist.*;
import hype.extended.layout.*;
import hype.interfaces.*;

HColorPool colors;

void setup() {
  size(640, 640);
  H.init(this).background(#111111);
  smooth();



  colors = new HColorPool(#B26C6C, #6C82B2, #6CB2B0, #B26E6C, #311716, #F2E4E3 );

  int starScale = 450;
  int starOffest = 10;

  for (int i=0; i<53; ++i) {
    HPath d = (HPath) H.add( new HPath().star(5, 0.5, -90) )
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
      .speed(0.4)
      .freq(3)
      .currentStep(i)
    ;

    starScale -= starOffest;
    
  }
}

void draw() {
  
 
  
  H.drawStage();
}