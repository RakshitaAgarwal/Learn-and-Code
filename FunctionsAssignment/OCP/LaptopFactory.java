package FunctionsAssignment.OCP;

import FunctionsAssignment.OCP.Model.Device;
import FunctionsAssignment.OCP.Model.Laptop;

public class LaptopFactory implements DeviceFactory{
    @Override
    public Device createDevice() {
        return new Laptop();
    }
}