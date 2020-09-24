

# INParam

A single parameter set for one object, for example face, describing the behaviour of the AI. Each object has default parameters that are set if these are empty.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**inClass** | [**InClassEnum**](#InClassEnum) | The classification of the object, that the element refers to. Default parameter values are defined per classification object. The following list contains the default values for &#39;min&#39;, &#39;max&#39; and &#39;drawMode&#39; in order. * _face_ _(0, 3, 0)_ - Classification for human faces. * _child_ _(0, 0, 1)_ - Recognizes children&#39;s faces. Overwrites classification parameters of face. * _adult_ _(0, -1, 1)_ - Recognizes faces of adults that are not considered seniors. Overwrites classification parameters of face. * _senior_ _(0, -1, 1)_ - Recognizes faces of seniors. Overwrites classification parameters of face. * _hand_ _(0, -1, 0)_ - Classification for recognizing hands. * _breast_ _(0, 0, 2)_ - Object that recognizes female breasts. * _vulva_ _(0, 0, 2)_ - Object that recognizes vulvae. * _penis_ _(0, 0, 2)_ - Object that recognizes penises. * _vagina_ _(0, 0, 2)_ - Object that recognizes vaginae. * _buttocks_ _(0, 0, 2)_ - Object that recognizes buttocks. * _anus_ _(0, 0, 2)_ - Object that recognizes ani. * _illegalSymbols_ _(0, 0, 1)_ - Classification for symbols that are not permitted in Germany. |  [optional]
**min** | **Integer** | The minimum amount of objects allowed on the source media. Setting the value to -1 will cause the AI to ignore this rule. |  [optional]
**max** | **Integer** | The maximum amount of objects allowed on the source media. Setting the value to -1 will cause the AI to ignore this rule. |  [optional]
**drawMode** | **Integer** | The draw mode that will be used for the creating the media.  * _0_ - will draw nothing, * _1_ - will draw a frame with class name surrounding the object, * _2_ - will draw a filled rectangle that will mask the object, * _3_ - is a combination between _1_ and _2_ (frame/name + mask), * _6_ - will blur the object and * _7_ - is a combination between _1_ and _6_ (frame/name + blur). |  [optional]
**grey** | **Integer** | A grey scale color to use for masking. &#39;0&#39; will represent black, while the maximum &#39;255&#39; will be white. |  [optional]



## Enum: InClassEnum

Name | Value
---- | -----
FACE | &quot;face&quot;
CHILD | &quot;child&quot;
ADULT | &quot;adult&quot;
SENIOR | &quot;senior&quot;
HAND | &quot;hand&quot;
BREAST | &quot;breast&quot;
VULVA | &quot;vulva&quot;
PENIS | &quot;penis&quot;
VAGINA | &quot;vagina&quot;
BUTTOCKS | &quot;buttocks&quot;
ANUS | &quot;anus&quot;
NUDITYCHECK | &quot;nudityCheck&quot;
AGEVERIFICATION | &quot;ageVerification&quot;
ILLEGALSYMBOLS | &quot;illegalSymbols&quot;



