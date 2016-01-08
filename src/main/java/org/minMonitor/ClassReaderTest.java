package org.minMonitor;

import org.objectweb.asm.*;
import test.object.TestModel;

/**
 * Created by zhanggan on 12/9/15.
 */
public class ClassReaderTest extends ClassLoader {
    public static void main(String[] args) throws Exception {
        ClassReader classReader = new ClassReader(TestModel.class.getName());
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        MyClassVisitor classVisitor = new MyClassVisitor(Opcodes.ASM4, classWriter);
        classReader.accept(classVisitor, 0);

        byte[] code = classWriter.toByteArray();

        ClassReaderTest load = new ClassReaderTest();
        Class<?> appClass = load.defineClass(null, code, 0, code.length);
        appClass.getMethod("sayHello").invoke(appClass.newInstance(), new Object[]{});
    }

    static class MyClassVisitor extends ClassVisitor {
        public MyClassVisitor(int api, ClassVisitor cv) {
            super(api, cv);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
            if ("sayHello".equals(name)) {
                mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, "java/lang/System", "currentTimeMillis", "()J");
                mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V");
            }
            return mv;
        }
    }
}
