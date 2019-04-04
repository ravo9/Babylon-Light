# Babylon-Light by Rafal Ozog

A programming challenge given by Babylon Health

What is done:

1. General sketch of the app architecture, based on the MVVM model.
2. Networking part, which consists of API service and API Utils files. This part uses Retrofit and OkHttp libraries to communicate with Back-End.
3. General View displaying list of all posts (Recycler View). I have added a simple animation that occurs when posts are loaded into the RecyclerView.
These are also appropriate messages displayed by Toast when posts are loaded or when error occurs (simple implementation of error handling).

What I would like to add to this implementation, having more time:

1. Detailed View (I have created Activity file, but probably I would decide for Fragment rather).
2. Testing, especially Unit Tests (jUnit, Mockito).
3. Customized AppBar (in progress).
4. Loading progress bar (in progress).
5. Customized, planned, beautiful UI.
6. More animations.
