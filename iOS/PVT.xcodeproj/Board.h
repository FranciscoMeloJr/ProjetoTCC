//
//  Board.h
//  PVT
//
//  Created by Francisco on 2014-04-10.
//  Copyright (c) 2014 Quiet Study Area. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <Foundation/Foundation.h>
#include <stdlib.h>

//NSTimer *timer;
//int myTimer;
int counter = 0; //the number of trials
float CounterNumber = 0;
float AverageNumber;

@interface Board : UIViewController
{
    IBOutlet UIButton *Exit;
    IBOutlet UIButton *Again;
    IBOutlet UIButton *StartGame; //Start Button
    
    //IBOutlet UILabel *TimeLabel; //Timer Button
    IBOutlet UILabel *Instructions;
    IBOutlet UILabel *TimerDisplay;
    
    NSTimer *Timer;//Timer
    float *TotalTime;
}
//Timer:
-(void)TimerCount;
-(void)Stop;
-(IBAction)Start:(id)sender;
-(IBAction)Restart:(id)sender;

-(void)StartCounter:(int)r;

-(IBAction)ShowScore;//Segue

@end
