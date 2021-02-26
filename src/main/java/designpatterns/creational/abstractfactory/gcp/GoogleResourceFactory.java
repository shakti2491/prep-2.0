package designpatterns.creational.abstractfactory.gcp;


import designpatterns.creational.abstractfactory.Instance;
import designpatterns.creational.abstractfactory.ResourceFactory;
import designpatterns.creational.abstractfactory.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {
    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new GoogleComputeEngineInstance(capacity);
    }

    @Override
    public Storage createStorage(int capMb) {
        return new GoogleCloudStorage(capMb);
    }
}
