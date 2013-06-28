WaveFX
======


Installation (for developers)
-----------------------------

Download a repository using terminal command: ``git clone git@github.com:WaveFX/WaveFX.git``
 
Copy

      YOUR/DOWNLOAD/PATH/WaveFX/src/wavefx/resources/indicators/OsMAModIndicator.java
to 

      YOUR/JFOREX/PATH/JForex/Indicators/
    
>NOTE: typical path: /home/%USER%/JForex/Indicators

Copy:

      YOUR/DOWNLOAD/PATH/WaveFX/src/wavefx/resources/templates/wavefx.tmp
to

      YOUR/JFOREX/PATH/JForex/Templates/**

Copy 

      YOUR/DOWNLOAD/PATH/WaveFX/src/wavefx/WaveFX.java** file to **YOUR/JFOREX/PATH/JForex/Strategies**
   
>NOTE: You can create a symbolic links to these files inside **YOUR/JFOREX/PATH/JForex/** directory
   
Localize and run Your JForex click platform (double click on **jForex.jnlp**)
   
>NOTE You can download platform file from official Dukascopy website: https://www.dukascopy.com/client/demo/jclient/jforex.jnlp

Inside the platform You must open and compile OSMAModIndicator.

Now You can open a template file


notes:

- indicators source - http://www.dukascopy.com/jstore/board/
