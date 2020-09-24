

# INImage

Configures your detection. As there are literally hundreds of parameters,  INDefine uses prototypes to get usefull behaviour. This includes a default setting for parameters and rules that should be applied to images. You can combine multiple detections by using more than 1 prototype
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**proto** | [**ProtoEnum**](#ProtoEnum) | Name of commonly used rule sets (prototypes). That can be used to speed up the setup process. * _nudityCheck_ - Commonly used prototype to check for nudity. * _ageVerification_ - Checks if there are children, adults or seniors recognizable. This is intended to be a suggestion to help you implement further steps. * _illegalSymbols_ - Checks for symbols that are not permitted in Germany.  |  [optional]



## Enum: ProtoEnum

Name | Value
---- | -----
NUDITYCHECK | &quot;nudityCheck&quot;
AGEVERIFICATION | &quot;ageVerification&quot;
ILLEGALSYMBOLS | &quot;illegalSymbols&quot;



