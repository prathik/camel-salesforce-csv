#Camel Salesforce CSV component

Push CSV files into Salesforce from Camel

##Installation

    mvn install

##Usage

Route to defined as

    .to("sfcsv://test?batchSize=100&object=Object_Name__c")
