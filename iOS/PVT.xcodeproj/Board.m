//
//  Board.m
//  PVT
//
//  Created by Francisco on 2014-04-10.
//  Copyright (c) 2014 Quiet Study Area. All rights reserved.
//

#import "Board.h"

@interface Board ()

@end

@implementation Board

-(IBAction)StartBoard:(id)sender
{
    counter = 0;
    StartGame.hidden = YES;
    Instructions.hidden = YES;
    //TimeLabel.hidden = NO;
    //myTimer = createTimer;
    
    Exit.hidden = YES;
    
}


//Segue: jump to the last page
-(IBAction)ShowScore
{
    [self performSegueWithIdentifier:@"ShowScore" sender:self];

}
-(void)Stop
{
    
    [Timer invalidate];
    Exit.hidden= NO;
    Again.hidden = NO;
    
    AverageNumber = 0;
    counter = counter + 1;
    
    //initiate = false;
}
-(IBAction)Start:(id)sender
{
    CounterNumber = 0;
    TotalTime = 0;
    
    StartGame.hidden = YES;
    Instructions.hidden = YES;
    Exit.hidden = YES;
    Again.hidden = YES;
    
    counter = counter + 1;
    int r = (arc4random() % 2)+1;
    
    
    [ self StartCounter:r];
    
}
-(IBAction)Restart:(id)sender
{
        CounterNumber = 0;
        TimerDisplay.text = [NSString stringWithFormat:@"0.000"];
        //CounterNumber = 0;
        //Timer = [NSTimer scheduledTimerWithTimeInterval:0.001 target:self selector:@selector(TimerCount) userInfo:nil repeats:YES];
    
    [self performSelector:@selector(Start:) withObject:nil afterDelay:0.35];
}
-(IBAction)TimerCount
{
    CounterNumber = CounterNumber + 0.001;
    TimerDisplay.text = [NSString stringWithFormat:@"%.3f", CounterNumber];
}

-(void)StartCounter:(int)r
{
    Timer = [NSTimer scheduledTimerWithTimeInterval:0.001 target:self selector:@selector(TimerCount) userInfo:nil repeats:YES];

}
-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{

    [self Stop];
    
}


- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    //TimeLabel.hidden = YES; //Hide the
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
