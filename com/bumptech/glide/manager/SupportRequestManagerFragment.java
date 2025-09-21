package com.bumptech.glide.manager;

import androidx.fragment.app.Fragment;
import com.bumptech.glide.RequestManager;

@Deprecated
public class SupportRequestManagerFragment extends Fragment {
    @Deprecated
    public void setRequestManager(RequestManager requestManager) {
    }

    @Deprecated
    public RequestManager getRequestManager() {
        return null;
    }

    @Deprecated
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return new EmptyRequestManagerTreeNode();
    }
}
