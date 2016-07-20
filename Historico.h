//
//  Historico.h
//  PVT
//
//  Created by Francisco on 2014-10-30.
//  Copyright (c) 2014 Quiet Study Area. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreData/CoreData.h>


@interface Historico : NSManagedObject

@property (nonatomic, retain) NSNumber * score1;
@property (nonatomic, retain) NSNumber * time;
@property (nonatomic, retain) NSNumber * score2;
@property (nonatomic, retain) NSNumber * score3;
@property (nonatomic, retain) NSNumber * score4;
@property (nonatomic, retain) NSNumber * score5;

@end
