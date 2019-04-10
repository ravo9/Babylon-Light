# Babylon-Light by Rafal Ozog

A programming challenge given by Babylon Health

1. The app architecture is based on the MVVM Design Pattern. Each screen consists of Activity or Fragment and its relevant ViewModel, being responsible for providing data.

2. The central part of data flow is Data Repository that has 2 main tasks. First is to fetch data from the Back-End (it's performed using separate ApiService), to cache it, and make accessible for particular viewmodels.

Caching mechanism allows to use the application after the Internet connection is interrupted.

3. ApiService consists of ApiClient (which is the final gate of this Front-End application) and ApiUtils class (being its interface). This part uses Retrofit2 library to perform communication with server.

Flow of data given by server is operated by RxJava (Reactive Java) observables, that allows to manage data streams given by few separate end-points simultaneously, and its potential error states.

GSON library is used for de-serializing data flowing from the Back-End.

4. Unit Testing part consists of Local Unit Testing (performed for data models, like User and Post), and Instrumented Unit Testing (performed for Data Repository caching mechanism). 

5. Alpha Testing has been separated from coding phase, and performed by developer on physical device.