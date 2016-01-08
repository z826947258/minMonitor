package org.minMonitor;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Created by zhanggan on 12/8/15.
 */
public class ClassWriterTest extends ClassLoader {
    public static void main(String[] args) throws Exception {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        classWriter.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, "test/object/TestModel", null, "java/lang/Object", null);

        MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(0, 0);
        methodVisitor.visitEnd();

        methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "sayHello", "()V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitLdcInsn("Hello World!!!");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(0, 0);
        methodVisitor.visitEnd();
        classWriter.visitEnd();

        byte[] code = classWriter.toByteArray();

        ClassWriterTest load = new ClassWriterTest();
        Class<?> appClass = load.defineClass(null, code, 0, code.length);
        appClass.getMethods()[0].invoke(appClass.newInstance(), new Object[]{});
    }
}
