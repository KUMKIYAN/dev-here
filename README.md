# dev-here

Given Task:

Cucumber environment with Gherkin support (any programming language can be used).

1.      For given URL (https://developer.here.com/documentation) validate all internal links on the page if accessible.

·        page is rendered and status is 2xx

2.      As developer.here.com uses AngularJS for frontend, verify if on page Angular was initialised



Follow below steps-

Load https://developer.here.com/documentation and check if page loads properly and angular is initialized
Find all links on page that are internal to documentation site (/documentation). Ignore anything that points outside https://developer.here.com/documentation) – external links or links in header/footer that are not related to documentation
For each link check if page loads and angular is initialized
Fail test if page doesn’t load or angular is not initialized


Solution

The above task can be completed in two ways.

1.  one is by through using service
2.  second one is by using ui.

clone the project : git clone git@github.com:KUMKIYAN/dev-here.git

import this maven project into eclipse / intellij

to run through services give CucumberOptions as ->  tags = {"@service_navigation"}) in the file "/developer-here/src/main/java/runner/MainRunner.java"

to run through ui give CucumberOptions as ->  tags = {"@service_navigation"}) in the file "/developer-here/src/main/java/runner/MainRunner.java"

to run through both services and ui give CucumberOptions as  -> tags = {"@all_scenarios"}) in the file "/developer-here/src/main/java/runner/MainRunner.java"

Once test runs we can see target folder generated.

open the "developer-here/target/cucumber-reports/index.html" in a browser to see cucumber report.
