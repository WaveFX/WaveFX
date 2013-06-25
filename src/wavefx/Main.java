/*
 * WaveFX EA
 */
package wavefx;

import com.dukascopy.api.Configurable;
import com.dukascopy.api.IAccount;
import com.dukascopy.api.IBar;
import com.dukascopy.api.IConsole;
import com.dukascopy.api.IContext;
import com.dukascopy.api.IIndicators;
import com.dukascopy.api.IMessage;
import com.dukascopy.api.IStrategy;
import com.dukascopy.api.ITick;
import com.dukascopy.api.Instrument;
import com.dukascopy.api.JFException;
import com.dukascopy.api.OfferSide;
import com.dukascopy.api.Period;



/**
 *
 * @author WaveFX
 */
public class Main implements IStrategy {

    //Configurable parameters
    @Configurable("Instrument") public Instrument instrument = Instrument.EURUSD;  
    
    
    
    // Class variables
    private IConsole console;
    private IIndicators indicators;
    
    
    
    @Override public void onStart(IContext context) throws JFException {
        
        // Get objects from context
        this.indicators = context.getIndicators();
        this.console = context.getConsole();
        
        //TODO: remove all indicators from chart
        
        // Get indicators values
        double ema = indicators.ema(instrument, Period.ONE_HOUR, OfferSide.BID, IIndicators.AppliedPrice.CLOSE, 5, 3);
        
        // Test
        console.getOut().println(ema);
    }
    
    @Override public void onTick(Instrument instrument, ITick tick) throws JFException { }

    @Override public void onBar(Instrument instrument, Period period, IBar askBar, IBar bidBar) throws JFException {}

    @Override public void onMessage(IMessage message) throws JFException { }

    @Override public void onAccount(IAccount account) throws JFException { }

    @Override public void onStop() throws JFException { }
}
