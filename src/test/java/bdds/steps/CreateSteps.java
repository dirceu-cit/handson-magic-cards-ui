package bdds.steps;

import magiccards.ui.entities.Expansion;
import magiccards.ui.proxies.ExpansionsFacadeProxy;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateSteps extends Steps {
    @Autowired
    private ExpansionsFacadeProxy proxy;

    @Given("a expansion created with name $name")
    public void createExpansionStep(String name){

        Expansion exp = new Expansion("test",name,"test",
                "test","test","test",new Integer(501),Boolean.TRUE,Boolean.FALSE);
        proxy.create(exp);

    }

}
