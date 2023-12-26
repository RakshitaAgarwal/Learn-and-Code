package FunctionsAssignment.OCP;

import FunctionsAssignment.OCP.Model.Device;
import FunctionsAssignment.OCP.Model.Smartphone;

public class SmartphoneFactory implements DeviceFactory{
    @Override
    public Device createDevice() {
        return new Smartphone();
    }
}
