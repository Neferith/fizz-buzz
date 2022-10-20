# fizz-buzz

## Explain the choices you made.

* For performance issue, fizz-buzz use a recycler view.The calculation is performed when a data is displayed on the screen and the result is not stored.
* I use independent Fragments, which could possibly be used in other views. To avoid dependencies between different Fragments and Activities, I pass the parameters through an intent. My data model implement the **Parcelable** interface
* No used other framework, features are very basic.

## What would you improve if you had more time ?

* Typically the GUI which is very basic. 
* In particular the validation of the form. 
* The functions of the application should be explained. Currently this is not the case
* Check the app on other device (Tablet)
