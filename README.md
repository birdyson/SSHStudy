# SSHStudy
> *author: AlexanderRon*

####This is my first project to learn SSH  
It contains:   
Struts2:  
* Action: 
  + UserAction for userinfo
  + DemoAction for test page
  + ErrorAction for return error message
* Service: 
  + UserService for user info service
* DAO:
  + UserDao for base userinfo connection, and contains ArrayList to simulate SQL
* filter:
  + EncodingFilter: to support chinese request and response
* interceptor:
  + LoginInterceptor: detects if the user is logged in, and intercepts if not logged in
  + TimeInterceptor: Check whether the user enters the demo page within the specified time period, and intercept if not open during the time period
