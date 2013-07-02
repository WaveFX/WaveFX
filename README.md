WaveFX
======



What is WaveFX?
---------------

TODO: comming soon


>NOTE: user guide is prepared for developers



Installing strategy template
----------------------------

Download a repository using terminal command: ``git clone git@github.com:WaveFX/WaveFX.git``
 
Copy

      YOUR/DOWNLOAD/PATH/WaveFX/src/wavefx/resources/indicators/OsMAModIndicator.java
to 

      YOUR/JFOREX/PATH/JForex/Indicators/
    
>NOTE: typical path: /home/%USER%/JForex/Indicators

Copy:

      YOUR/DOWNLOAD/PATH/WaveFX/src/wavefx/resources/templates/wavefx.tmp
to

      YOUR/JFOREX/PATH/JForex/Templates/

Copy 

      YOUR/DOWNLOAD/PATH/WaveFX/src/wavefx/WaveFX.java file to YOUR/JFOREX/PATH/JForex/Strategies
   
>NOTE: You can create a symbolic links to these files inside **YOUR/JFOREX/PATH/JForex/** directory
   
Localize and run Your JForex click platform (double click on **jForex.jnlp**)
   
>NOTE You can download platform file from official Dukascopy website: https://www.dukascopy.com/client/demo/jclient/jforex.jnlp

Inside the platform (find a ``Workspace`` section) You must open and **compile** OSMAModIndicator.

Finally go to 

      YOUR/DOWNLOAD/PATH/WaveFX/src/wavefx/resources/templates/
      
and drop **wavefx.tmp** file in chart window. That all!



Run strategy inside JForex platform
-----------------------------------

Open and compile **WaveFX.java** from ``Workspace`` section (go to the ``Strategies`` directory).

After compilation click on the **WaveFX** by right mouse button and select **Local run** option from context menu.

Now strategy works! :)



Nearest actions
---------------

- [  ] create a position open module
- [  ] create a position close module



Notes
-----

- indicators source - http://www.dukascopy.com/jstore/board/
