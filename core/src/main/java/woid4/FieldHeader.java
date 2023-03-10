package woid4;

import org.objectweb.asm.ClassVisitor;

public class FieldHeader {

    private int access;
    private String name;
    private String descriptor;
    private String signature;
    private Object value;
    private ClassVisitor context;

    public FieldHeader(int access, String name, String descriptor, String signature, Object value) {
        this.access = access;
        this.name = name;
        this.descriptor = descriptor;
        this.signature = signature;
        this.value = value;
    }

    public int getAccess() {
        return this.access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "FieldHeader{" +
                "access=" + access +
                ", name='" + name + '\'' +
                ", descriptor='" + descriptor + '\'' +
                ", signature='" + signature + '\'' +
                ", value=" + value +
                '}';
    }

    public void accept(ClassVisitor visitor) {
        this.context = visitor;
    }

    public void visit() {
        this.visit(this.context);
    }

    public void visit(ClassVisitor context) {
        context.visitField(this.access, this.name, this.descriptor, this.signature, this.value);
    }
}
