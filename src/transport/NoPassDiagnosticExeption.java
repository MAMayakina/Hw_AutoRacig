package transport;

public class NoPassDiagnosticExeption extends Exception{

    private Transport transport;

    public NoPassDiagnosticExeption(String message, Transport transport) {
        super(message);
        this.transport = transport;
    }

    public NoPassDiagnosticExeption(String message) {
        super(message);
    }

    public Transport getTransport(){
        return transport;
    }
}
