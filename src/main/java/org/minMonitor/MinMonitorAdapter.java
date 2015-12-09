package org.minMonitor;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassVisitor;

/**
 * Created by zhanggan on 12/8/15.
 */
public class MinMonitorAdapter extends ClassAdapter {
    public MinMonitorAdapter(ClassVisitor classVisitor) {
        super(classVisitor);
    }
}
