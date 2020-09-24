

# IrisNet

Contains information on the AI result from the source media check.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**rulesBroken** | **Integer** | The amount of broken rules that are contained in the source media. |  [optional]
**helpSuggested** | **Integer** | In cases where the AI is uncertain, this attribute is set (1), indication that it could be useful to double check the source media by a human. |  [optional]
**getnObjects** | **Integer** | The amount of objects that were recognized on the source media. |  [optional]
**getnClasses** | **Integer** | The amount of classification objects that were checked against on the source media. This does not mean that all of the classifications were found. |  [optional]
**inRule** | [**List&lt;INRule&gt;**](INRule.md) | This list contains one rule per classification. Rules for classification objects that were not found, are omitted. |  [optional]
**inObject** | [**List&lt;INObject&gt;**](INObject.md) | A list of all instances of the classification objects found on the source media. |  [optional]



