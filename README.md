#Camel Salesforce CSV component

Upload CSV to Salesforce using Apache Camel

##Why Apache Camel?

Camel provides support for different type of systems such as MySQL, file systems, kafka and rabbitmq. It also provides support to use timers such as quartz and its own timer implementaion. Camel is a good, open source candidate for simple enterprise integration.

##Why salesforce csv component?

This component focuses on uploading csv only. You can transform output from any system to a csv and upload it to Salesforce.

##Why not other camel salesforce components?

The main reason I didn't go into already existing components is because it didn't have an easy and intuitive way to upload csv into salesforce objects, which is what I wanted. This component purely focuses on csv upload to salesforce.

##Installation

    mvn install

##Usage

Route to defined as

    .to("sfcsv://test?batchSize=100&object=Object_Name__c")
