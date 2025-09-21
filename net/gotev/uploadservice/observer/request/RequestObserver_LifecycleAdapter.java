package net.gotev.uploadservice.observer.request;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class RequestObserver_LifecycleAdapter implements GeneratedAdapter {
    final RequestObserver mReceiver;

    RequestObserver_LifecycleAdapter(RequestObserver receiver) {
        this.mReceiver = receiver;
    }

    public void callMethods(LifecycleOwner owner, Lifecycle.Event event, boolean onAny, MethodCallsLogger logger) {
        boolean hasLogger = logger != null;
        if (!onAny) {
            if (event == Lifecycle.Event.ON_RESUME) {
                if (!hasLogger || logger.approveCall("register", 1)) {
                    this.mReceiver.register();
                }
            } else if (event != Lifecycle.Event.ON_PAUSE) {
            } else {
                if (!hasLogger || logger.approveCall("unregister", 1)) {
                    this.mReceiver.unregister();
                }
            }
        }
    }
}
