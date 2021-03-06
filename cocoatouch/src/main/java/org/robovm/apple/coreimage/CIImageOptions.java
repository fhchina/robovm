/*
 * Copyright (C) 2013-2015 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.robovm.apple.coreimage;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import org.robovm.objc.*;
import org.robovm.objc.annotation.*;
import org.robovm.objc.block.*;
import org.robovm.rt.*;
import org.robovm.rt.bro.*;
import org.robovm.rt.bro.annotation.*;
import org.robovm.rt.bro.ptr.*;
import org.robovm.apple.coregraphics.*;
import org.robovm.apple.foundation.*;
import org.robovm.apple.corefoundation.*;
import org.robovm.apple.opengles.*;
import org.robovm.apple.corevideo.*;
import org.robovm.apple.imageio.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
@Marshaler(CIImageOptions.Marshaler.class)
/*<annotations>*/@Library("CoreImage")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CIImageOptions/*</name>*/ 
    extends /*<extends>*/CocoaUtility/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class Marshaler {
        @MarshalsPointer
        public static CIImageOptions toObject(Class<CIImageOptions> cls, long handle, long flags) {
            CFDictionary o = (CFDictionary) CFType.Marshaler.toObject(CFDictionary.class, handle, flags);
            if (o == null) {
                return null;
            }
            return new CIImageOptions(o);
        }
        @MarshalsPointer
        public static long toNative(CIImageOptions o, long flags) {
            if (o == null) {
                return 0L;
            }
            return CFType.Marshaler.toNative(o.data, flags);
        }
    }
    
    /*<ptr>*/
    /*</ptr>*/
    private CFDictionary data;
    
    protected CIImageOptions(CFDictionary data) {
        this.data = data;
    }
    public CIImageOptions() {
        this.data = CFMutableDictionary.create();
    }
    /*<bind>*/static { Bro.bind(CIImageOptions.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public CFDictionary getDictionary() {
        return data;
    }
    
    
    public CGColorSpace getColorSpace() {
        if (data.containsKey(ColorSpaceKey())) {
            CGColorSpace val = data.get(ColorSpaceKey(), CGColorSpace.class);
            return val;
        }
        return null;
    }
    public CIImageOptions setColorSpace(CGColorSpace colorSpace) {
        data.put(ColorSpaceKey(), colorSpace);
        return this;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public CGImageProperties getProperties() {
        if (data.containsKey(PropertiesKey())) {
            CFDictionary val = data.get(PropertiesKey(), CFDictionary.class);
            return new CGImageProperties(val);
        }
        return null;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public CIImageOptions setProperties(CGImageProperties properties) {
        data.put(PropertiesKey(), properties.getDictionary());
        return this;
    }
    /*<methods>*/
    @GlobalValue(symbol="kCIImageColorSpace", optional=true)
    protected static native CFString ColorSpaceKey();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalValue(symbol="kCIImageProperties", optional=true)
    protected static native CFString PropertiesKey();
    /*</methods>*/
    @Override
    public String toString() {
        if (data != null) return data.toString();
        return super.toString();
    }
}
