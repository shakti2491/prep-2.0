package designpatterns.behavioral.command;

public class AddMemberCommand implements ICommand{
    private String emailAddress;
    private String listName;
    private  EWSService receiver;


    public AddMemberCommand(String emailAddress, String listName, EWSService service) {
        this.emailAddress = emailAddress;
        this.listName  =listName;
        this.receiver = service;
    }

    @Override
    public void execute() {
        this.receiver.addMember(emailAddress,listName);
    }
}
