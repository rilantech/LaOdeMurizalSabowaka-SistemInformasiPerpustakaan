package cn.pedant.SweetAlert;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class OptAnimationLoader {
    public static Animation loadAnimation(Context context, int id) throws Resources.NotFoundException {
        XmlResourceParser parser = null;
        try {
            XmlResourceParser parser2 = context.getResources().getAnimation(id);
            Animation createAnimationFromXml = createAnimationFromXml(context, parser2);
            if (parser2 != null) {
                parser2.close();
            }
            return createAnimationFromXml;
        } catch (XmlPullParserException ex) {
            Resources.NotFoundException rnf = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex2) {
            Resources.NotFoundException rnf2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf2.initCause(ex2);
            throw rnf2;
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
            throw th;
        }
    }

    private static Animation createAnimationFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        return createAnimationFromXml(c, parser, (AnimationSet) null, Xml.asAttributeSet(parser));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r6.equals("rotate") != false) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.view.animation.Animation createAnimationFromXml(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11, android.view.animation.AnimationSet r12, android.util.AttributeSet r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = 0
            int r1 = r11.getDepth()
        L_0x0005:
            int r2 = r11.next()
            r3 = r2
            r4 = 3
            if (r2 != r4) goto L_0x0013
            int r2 = r11.getDepth()
            if (r2 <= r1) goto L_0x00db
        L_0x0013:
            r2 = 1
            if (r3 == r2) goto L_0x00db
            r5 = 2
            if (r3 == r5) goto L_0x001a
            goto L_0x0005
        L_0x001a:
            java.lang.String r6 = r11.getName()
            r7 = -1
            int r8 = r6.hashCode()
            r9 = 0
            switch(r8) {
                case -925180581: goto L_0x0051;
                case 113762: goto L_0x0047;
                case 92909918: goto L_0x003d;
                case 109250890: goto L_0x0033;
                case 1052832078: goto L_0x0028;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x005a
        L_0x0028:
            java.lang.String r4 = "translate"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0027
            r4 = 4
            goto L_0x005b
        L_0x0033:
            java.lang.String r4 = "scale"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0027
            r4 = r5
            goto L_0x005b
        L_0x003d:
            java.lang.String r4 = "alpha"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0027
            r4 = r2
            goto L_0x005b
        L_0x0047:
            java.lang.String r4 = "set"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0027
            r4 = r9
            goto L_0x005b
        L_0x0051:
            java.lang.String r8 = "rotate"
            boolean r8 = r6.equals(r8)
            if (r8 == 0) goto L_0x0027
            goto L_0x005b
        L_0x005a:
            r4 = r7
        L_0x005b:
            switch(r4) {
                case 0: goto L_0x007f;
                case 1: goto L_0x0078;
                case 2: goto L_0x0071;
                case 3: goto L_0x006a;
                case 4: goto L_0x0063;
                default: goto L_0x005e;
            }
        L_0x005e:
            java.lang.Class r4 = java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x00af }
            goto L_0x008c
        L_0x0063:
            android.view.animation.TranslateAnimation r2 = new android.view.animation.TranslateAnimation
            r2.<init>(r10, r13)
            r0 = r2
            goto L_0x00a8
        L_0x006a:
            android.view.animation.RotateAnimation r2 = new android.view.animation.RotateAnimation
            r2.<init>(r10, r13)
            r0 = r2
            goto L_0x00a8
        L_0x0071:
            android.view.animation.ScaleAnimation r2 = new android.view.animation.ScaleAnimation
            r2.<init>(r10, r13)
            r0 = r2
            goto L_0x00a8
        L_0x0078:
            android.view.animation.AlphaAnimation r2 = new android.view.animation.AlphaAnimation
            r2.<init>(r10, r13)
            r0 = r2
            goto L_0x00a8
        L_0x007f:
            android.view.animation.AnimationSet r2 = new android.view.animation.AnimationSet
            r2.<init>(r10, r13)
            r0 = r2
            r2 = r0
            android.view.animation.AnimationSet r2 = (android.view.animation.AnimationSet) r2
            createAnimationFromXml(r10, r11, r2, r13)
            goto L_0x00a8
        L_0x008c:
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x00af }
            java.lang.Class<android.content.Context> r8 = android.content.Context.class
            r7[r9] = r8     // Catch:{ Exception -> 0x00af }
            java.lang.Class<android.util.AttributeSet> r8 = android.util.AttributeSet.class
            r7[r2] = r8     // Catch:{ Exception -> 0x00af }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r7)     // Catch:{ Exception -> 0x00af }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x00af }
            r5[r9] = r10     // Catch:{ Exception -> 0x00af }
            r5[r2] = r13     // Catch:{ Exception -> 0x00af }
            java.lang.Object r2 = r4.newInstance(r5)     // Catch:{ Exception -> 0x00af }
            android.view.animation.Animation r2 = (android.view.animation.Animation) r2     // Catch:{ Exception -> 0x00af }
            r0 = r2
        L_0x00a8:
            if (r12 == 0) goto L_0x00ad
            r12.addAnimation(r0)
        L_0x00ad:
            goto L_0x0005
        L_0x00af:
            r2 = move-exception
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Unknown animation name: "
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r7 = r11.getName()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r7 = " error:"
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r7 = r2.getMessage()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x00db:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.pedant.SweetAlert.OptAnimationLoader.createAnimationFromXml(android.content.Context, org.xmlpull.v1.XmlPullParser, android.view.animation.AnimationSet, android.util.AttributeSet):android.view.animation.Animation");
    }
}
