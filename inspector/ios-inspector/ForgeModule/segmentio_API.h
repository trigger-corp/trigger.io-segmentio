#import <Foundation/Foundation.h>

@interface segmentio_API : NSObject

+ (void)identify:(ForgeTask*)task userId:(NSString *)userId traits:(NSDictionary *)traits;
+ (void)track:(ForgeTask*)task event:(NSString *)event properties:(NSDictionary *)properties;
+ (void)screen:(ForgeTask*)task screenTitle:(NSString *)screenTitle properties:(NSDictionary *)properties;

@end
