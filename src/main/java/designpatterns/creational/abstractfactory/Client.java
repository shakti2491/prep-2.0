package designpatterns.creational.abstractfactory;

import designpatterns.creational.abstractfactory.aws.AwsResourceFactory;
import designpatterns.creational.abstractfactory.gcp.GoogleResourceFactory;

public class Client {

    private ResourceFactory factory;

    public Client(ResourceFactory factory){
        this.factory = factory;
    }

    public Instance createServer(Instance.Capacity capacity, int storageMb){
        Instance instance = factory.createInstance(capacity);
        Storage storage = factory.createStorage(storageMb);
        instance.attachStorage(storage);
        return instance;
    }

    public static void main(String[] args) {
        Client aws = new Client(new AwsResourceFactory());
        Instance i1 = aws.createServer(Instance.Capacity.micro,20480);
        i1.start();
        i1.stop();

        Client gcp = new Client(new GoogleResourceFactory());
        Instance i2 = gcp.createServer(Instance.Capacity.micro,20480);
        i2.start();
        i2.stop();
    }
}
