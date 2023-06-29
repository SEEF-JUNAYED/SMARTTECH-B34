@Smoke @Regression
Feature: Login function test
description:

@Positive @TC_OB_18
Scenario: Check login with valid credentials

Given Open browser and go to the application
When Put valid username
When Put valid password
When Clicl login
Then check if logout button visible or not


@Negetive @TC_OB_19
Scenario: Check login with invalid credentials

Given Open browser and go to the application
When Put invalid username
When Put invalid password
When Clicl login
Then check if it is giving Alert msg Invalid username or password


@Negetive @TC_OB_20
Scenario: Check login with invalid credentials

Given Open browser and go to the application
When Put null username
When Put null password
When Clicl login
Then check if it is giving Alert msg Invalid username or password

