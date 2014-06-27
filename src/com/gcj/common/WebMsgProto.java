package com.gcj.common;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class WebMsgProto {
    private static Descriptors.Descriptor internal_static_pbmsg_WebItem_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_WebItem_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_MsgPack_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_MsgPack_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_SiteItem_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_SiteItem_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_SiteUrlItem_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_SiteUrlItem_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_SiteUrlRecord_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_SiteUrlRecord_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_LogActionItem_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_LogActionItem_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_LogActionRecord_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_LogActionRecord_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_KVPair_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_KVPair_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_LinkVisitActionItem_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_LinkVisitActionItem_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_Visitor_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_Visitor_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_Referer_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_Referer_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_Config_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_Config_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_Location_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_Location_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_LocationGeoip_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_LocationGeoip_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_pbmsg_LogVisitItem_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_LogVisitItem_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    static {
        String[] descriptorData = {"\n\fwebmsg.proto\022\005pbmsg\"\032\n\007WebItem\022\017\n\007msgpack\030\001 \002(\t\"æ\001\n\007MsgPack\022!\n\bsiteItem\030\001 \003(\0132\017.pbmsg.SiteItem\022'\n\013siteUrlItem\030\002 \003(\0132\022.pbmsg.SiteUrlItem\022+\n\rlogActionItem\030\003 \003(\0132\024.pbmsg.LogActionItem\0227\n\023linkVisitActionItem\030\004 \003(\0132\032.pbmsg.LinkVisitActionItem\022)\n\flogVisitItem\030\005 \003(\0132\023.pbmsg.LogVisitItem\"é\002\n\bSiteItem\022\016\n\006idsite\030\001 \002(\005\022\f\n\004name\030\002 \002(\t\022\020\n\bmain_url\030\003 \002(\t\022\022\n\nts_created\030\004 \002(\003\022\021\n\tecommerce\030\005 \002(\005\022\020\n\btimezone\030\006 \002(\t", "\022\020\n\bcurrency\030\007 \002(\t\022\024\n\fexcluded_ips\030\b \002(\t\022\033\n\023excluded_parameters\030\t \002(\t\022\034\n\024excluded_user_agents\030\n \002(\t\022\025\n\nsitesearch\030\013 \002(\005:\0011\022%\n\035sitesearch_keyword_parameters\030\f \002(\t\022&\n\036sitesearch_category_parameters\030\r \002(\t\022\r\n\005group\030\016 \002(\t\022\034\n\021keep_url_fragment\030\017 \002(\005:\0010\"H\n\013SiteUrlItem\022\022\n\nts_updated\030\001 \002(\003\022%\n\007siteurl\030\002 \003(\0132\024.pbmsg.SiteUrlRecord\",\n\rSiteUrlRecord\022\016\n\006idsite\030\001 \002(\005\022\013\n\003url\030\002 \002(\t\"N\n\rLogActionItem\022\022\n\nts_updated\030\001 ", "\002(\003\022)\n\tlogaction\030\002 \003(\0132\026.pbmsg.LogActionRecord\"a\n\017LogActionRecord\022\020\n\bidaction\030\001 \002(\005\022\f\n\004name\030\002 \002(\t\022\f\n\004hash\030\003 \002(\005\022\f\n\004type\030\004 \002(\005\022\022\n\nurl_prefix\030\005 \002(\005\"$\n\006KVPair\022\013\n\003key\030\001 \002(\t\022\r\n\005value\030\002 \002(\t\"\002\n\023LinkVisitActionItem\022\021\n\tidlink_va\030\001 \002(\005\022\016\n\006idsite\030\002 \002(\005\022\021\n\tidvisitor\030\003 \002(\f\022\023\n\013server_time\030\004 \002(\003\022\017\n\007idvisit\030\005 \002(\005\022\024\n\fidaction_url\030\006 \002(\005\022\030\n\020idaction_url_ref\030\007 \002(\005\022\025\n\ridaction_name\030\b \002(\005\022\031\n\021idaction_name_ref\030\t \002(\005\022\035\n", "\025time_spent_ref_action\030\n \002(\005\022\035\n\006kvpair\030\013 \003(\0132\r.pbmsg.KVPair\"¹\003\n\007Visitor\022\021\n\tidvisitor\030\001 \002(\f\022\021\n\tlocaltime\030\002 \002(\005\022\021\n\treturning\030\003 \002(\005\022\024\n\fcount_visits\030\004 \002(\005\022\027\n\017days_since_last\030\005 \002(\005\022\030\n\020days_since_order\030\006 \002(\005\022\030\n\020days_since_first\030\007 \002(\005\022\031\n\021first_action_time\030\b \002(\003\022\030\n\020last_action_time\030\t \002(\003\022\031\n\021exit_idaction_url\030\n \002(\005\022\032\n\022exit_idaction_name\030\013 \002(\005\022\032\n\022entry_idaction_url\030\f \002(\005\022\033\n\023entry_idaction_name\030\r \002(\005\022\025\n\rtota", "l_actions\030\016 \002(\005\022\026\n\016total_searches\030\017 \002(\005\022\022\n\ntotal_time\030\020 \002(\005\022\026\n\016goal_converted\030\021 \002(\005\022\022\n\ngoal_buyer\030\022 \002(\005\"C\n\007Referer\022\f\n\004type\030\001 \002(\005\022\f\n\004name\030\002 \002(\t\022\013\n\003url\030\003 \002(\t\022\017\n\007keyword\030\004 \002(\t\"\002\n\006Config\022\n\n\002id\030\001 \002(\f\022\n\n\002os\030\002 \002(\t\022\024\n\fbrowser_name\030\003 \002(\t\022\027\n\017browser_version\030\004 \002(\t\022\022\n\nresolution\030\005 \002(\t\022\013\n\003pdf\030\006 \002(\005\022\r\n\005flash\030\007 \002(\005\022\f\n\004java\030\b \002(\005\022\020\n\bdirector\030\t \002(\005\022\021\n\tquicktime\030\n \002(\005\022\022\n\nrealplayer\030\013 \002(\005\022\024\n\fwindowsmedia\030\f \002(\005\022\r\n\005g", "ears\030\r \002(\005\022\023\n\013silverlight\030\016 \002(\005\022\016\n\006cookie\030\017 \002(\005\"\001\n\bLocation\022\n\n\002ip\030\001 \002(\f\022\024\n\fbrowser_lang\030\002 \002(\t\022\017\n\007country\030\003 \002(\t\022\016\n\006region\030\004 \002(\t\022\f\n\004city\030\005 \002(\t\022\020\n\blatitude\030\006 \002(\002\022\032\n\022location_longitude\030\007 \002(\002\"x\n\rLocationGeoip\022\020\n\bprovider\030\001 \002(\t\022\021\n\tcontinent\030\002 \002(\t\022\017\n\007country\030\003 \002(\t\022\f\n\004city\030\004 \002(\t\022\020\n\blatitude\030\005 \002(\001\022\021\n\tlongitude\030\006 \002(\001\"÷\001\n\fLogVisitItem\022\017\n\007idvisit\030\001 \002(\003\022\016\n\006idsite\030\002 \002(\003\022\037\n\007visitor\030\003 \002(\0132\016.pbmsg.Visitor\022\037\n\007refe", "rer\030\004 \002(\0132\016.pbmsg.Referer\022\035\n\006config\030\005 \002(\0132\r.pbmsg.Config\022!\n\blocation\030\006 \002(\0132\017.pbmsg.Location\022\035\n\006kvpair\030\007 \003(\0132\r.pbmsg.KVPair\022#\n\005geoip\030\b \002(\0132\024.pbmsg.LocationGeoipB\"\n\023com.gw.common.pbmsgB\013WebMsgProto"};

        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                WebMsgProto.descriptor = root;
                WebMsgProto.internal_static_pbmsg_WebItem_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(0);
                WebMsgProto.internal_static_pbmsg_WebItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_WebItem_descriptor, new String[]{"Msgpack"});
                WebMsgProto.internal_static_pbmsg_MsgPack_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(1);
                WebMsgProto.internal_static_pbmsg_MsgPack_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_MsgPack_descriptor, new String[]{"SiteItem", "SiteUrlItem", "LogActionItem", "LinkVisitActionItem", "LogVisitItem"});
                WebMsgProto.internal_static_pbmsg_SiteItem_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(2);
                WebMsgProto.internal_static_pbmsg_SiteItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_SiteItem_descriptor, new String[]{"Idsite", "Name", "MainUrl", "TsCreated", "Ecommerce", "Timezone", "Currency", "ExcludedIps", "ExcludedParameters", "ExcludedUserAgents", "Sitesearch", "SitesearchKeywordParameters", "SitesearchCategoryParameters", "Group", "KeepUrlFragment"});
                WebMsgProto.internal_static_pbmsg_SiteUrlItem_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(3);
                WebMsgProto.internal_static_pbmsg_SiteUrlItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_SiteUrlItem_descriptor, new String[]{"TsUpdated", "Siteurl"});
                WebMsgProto.internal_static_pbmsg_SiteUrlRecord_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(4);
                WebMsgProto.internal_static_pbmsg_SiteUrlRecord_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_SiteUrlRecord_descriptor, new String[]{"Idsite", "Url"});
                WebMsgProto.internal_static_pbmsg_LogActionItem_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(5);
                WebMsgProto.internal_static_pbmsg_LogActionItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_LogActionItem_descriptor, new String[]{"TsUpdated", "Logaction"});
                WebMsgProto.internal_static_pbmsg_LogActionRecord_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(6);
                WebMsgProto.internal_static_pbmsg_LogActionRecord_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_LogActionRecord_descriptor, new String[]{"Idaction", "Name", "Hash", "Type", "UrlPrefix"});
                WebMsgProto.internal_static_pbmsg_KVPair_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(7);
                WebMsgProto.internal_static_pbmsg_KVPair_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_KVPair_descriptor, new String[]{"Key", "Value"});
                WebMsgProto.internal_static_pbmsg_LinkVisitActionItem_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(8);
                WebMsgProto.internal_static_pbmsg_LinkVisitActionItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_LinkVisitActionItem_descriptor, new String[]{"IdlinkVa", "Idsite", "Idvisitor", "ServerTime", "Idvisit", "IdactionUrl", "IdactionUrlRef", "IdactionName", "IdactionNameRef", "TimeSpentRefAction", "Kvpair"});
                WebMsgProto.internal_static_pbmsg_Visitor_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(9);
                WebMsgProto.internal_static_pbmsg_Visitor_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_Visitor_descriptor, new String[]{"Idvisitor", "Localtime", "Returning", "CountVisits", "DaysSinceLast", "DaysSinceOrder", "DaysSinceFirst", "FirstActionTime", "LastActionTime", "ExitIdactionUrl", "ExitIdactionName", "EntryIdactionUrl", "EntryIdactionName", "TotalActions", "TotalSearches", "TotalTime", "GoalConverted", "GoalBuyer"});
                WebMsgProto.internal_static_pbmsg_Referer_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(10);
                WebMsgProto.internal_static_pbmsg_Referer_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_Referer_descriptor, new String[]{"Type", "Name", "Url", "Keyword"});
                WebMsgProto.internal_static_pbmsg_Config_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(11);
                WebMsgProto.internal_static_pbmsg_Config_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_Config_descriptor, new String[]{"Id", "Os", "BrowserName", "BrowserVersion", "Resolution", "Pdf", "Flash", "Java", "Director", "Quicktime", "Realplayer", "Windowsmedia", "Gears", "Silverlight", "Cookie"});
                WebMsgProto.internal_static_pbmsg_Location_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(12);
                WebMsgProto.internal_static_pbmsg_Location_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_Location_descriptor, new String[]{"Ip", "BrowserLang", "Country", "Region", "City", "Latitude", "LocationLongitude"});
                WebMsgProto.internal_static_pbmsg_LocationGeoip_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(13);
                WebMsgProto.internal_static_pbmsg_LocationGeoip_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_LocationGeoip_descriptor, new String[]{"Provider", "Continent", "Country", "City", "Latitude", "Longitude"});
                WebMsgProto.internal_static_pbmsg_LogVisitItem_descriptor = (Descriptors.Descriptor) WebMsgProto.getDescriptor().getMessageTypes().get(14);
                WebMsgProto.internal_static_pbmsg_LogVisitItem_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(WebMsgProto.internal_static_pbmsg_LogVisitItem_descriptor, new String[]{"Idvisit", "Idsite", "Visitor", "Referer", "Config", "Location", "Kvpair", "Geoip"});
                return null;
            }
        };
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static final class Config extends GeneratedMessage implements WebMsgProto.ConfigOrBuilder {
        private static final Config defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<Config> PARSER = new AbstractParser() {
            public WebMsgProto.Config parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.Config(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private ByteString id_;
        public static final int OS_FIELD_NUMBER = 2;
        private Object os_;
        public static final int BROWSER_NAME_FIELD_NUMBER = 3;
        private Object browserName_;
        public static final int BROWSER_VERSION_FIELD_NUMBER = 4;
        private Object browserVersion_;
        public static final int RESOLUTION_FIELD_NUMBER = 5;
        private Object resolution_;
        public static final int PDF_FIELD_NUMBER = 6;
        private int pdf_;
        public static final int FLASH_FIELD_NUMBER = 7;
        private int flash_;
        public static final int JAVA_FIELD_NUMBER = 8;
        private int java_;
        public static final int DIRECTOR_FIELD_NUMBER = 9;
        private int director_;
        public static final int QUICKTIME_FIELD_NUMBER = 10;
        private int quicktime_;
        public static final int REALPLAYER_FIELD_NUMBER = 11;
        private int realplayer_;
        public static final int WINDOWSMEDIA_FIELD_NUMBER = 12;
        private int windowsmedia_;
        public static final int GEARS_FIELD_NUMBER = 13;
        private int gears_;
        public static final int SILVERLIGHT_FIELD_NUMBER = 14;
        private int silverlight_;
        public static final int COOKIE_FIELD_NUMBER = 15;
        private int cookie_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new Config(true);
            defaultInstance.initFields();
        }

        private Config(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private Config(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Config getDefaultInstance() {
            return defaultInstance;
        }

        public Config getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Config(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.id_ = input.readBytes();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.os_ = input.readBytes();
                            break;
                        case 26:
                            this.bitField0_ |= 4;
                            this.browserName_ = input.readBytes();
                            break;
                        case 34:
                            this.bitField0_ |= 8;
                            this.browserVersion_ = input.readBytes();
                            break;
                        case 42:
                            this.bitField0_ |= 16;
                            this.resolution_ = input.readBytes();
                            break;
                        case 48:
                            this.bitField0_ |= 32;
                            this.pdf_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 64;
                            this.flash_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 128;
                            this.java_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 256;
                            this.director_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 512;
                            this.quicktime_ = input.readInt32();
                            break;
                        case 88:
                            this.bitField0_ |= 1024;
                            this.realplayer_ = input.readInt32();
                            break;
                        case 96:
                            this.bitField0_ |= 2048;
                            this.windowsmedia_ = input.readInt32();
                            break;
                        case 104:
                            this.bitField0_ |= 4096;
                            this.gears_ = input.readInt32();
                            break;
                        case 112:
                            this.bitField0_ |= 8192;
                            this.silverlight_ = input.readInt32();
                            break;
                        case 120:
                            this.bitField0_ |= 16384;
                            this.cookie_ = input.readInt32();
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_Config_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_Config_fieldAccessorTable.ensureFieldAccessorsInitialized(Config.class, Builder.class);
        }

        public Parser<Config> getParserForType() {
            return PARSER;
        }

        public boolean hasId() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public ByteString getId() {
            return this.id_;
        }

        public boolean hasOs() {
            return (this.bitField0_ & 0x2) == 2;
        }

        public String getOs() {
            Object ref = this.os_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.os_ = s;
            }
            return s;
        }

        public ByteString getOsBytes() {
            Object ref = this.os_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.os_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasBrowserName() {
            return (this.bitField0_ & 0x4) == 4;
        }

        public String getBrowserName() {
            Object ref = this.browserName_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.browserName_ = s;
            }
            return s;
        }

        public ByteString getBrowserNameBytes() {
            Object ref = this.browserName_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.browserName_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasBrowserVersion() {
            return (this.bitField0_ & 0x8) == 8;
        }

        public String getBrowserVersion() {
            Object ref = this.browserVersion_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.browserVersion_ = s;
            }
            return s;
        }

        public ByteString getBrowserVersionBytes() {
            Object ref = this.browserVersion_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.browserVersion_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasResolution() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public String getResolution() {
            Object ref = this.resolution_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.resolution_ = s;
            }
            return s;
        }

        public ByteString getResolutionBytes() {
            Object ref = this.resolution_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.resolution_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasPdf() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public int getPdf() {
            return this.pdf_;
        }

        public boolean hasFlash() {
            return (this.bitField0_ & 0x40) == 64;
        }

        public int getFlash() {
            return this.flash_;
        }

        public boolean hasJava() {
            return (this.bitField0_ & 0x80) == 128;
        }

        public int getJava() {
            return this.java_;
        }

        public boolean hasDirector() {
            return (this.bitField0_ & 0x100) == 256;
        }

        public int getDirector() {
            return this.director_;
        }

        public boolean hasQuicktime() {
            return (this.bitField0_ & 0x200) == 512;
        }

        public int getQuicktime() {
            return this.quicktime_;
        }

        public boolean hasRealplayer() {
            return (this.bitField0_ & 0x400) == 1024;
        }

        public int getRealplayer() {
            return this.realplayer_;
        }

        public boolean hasWindowsmedia() {
            return (this.bitField0_ & 0x800) == 2048;
        }

        public int getWindowsmedia() {
            return this.windowsmedia_;
        }

        public boolean hasGears() {
            return (this.bitField0_ & 0x1000) == 4096;
        }

        public int getGears() {
            return this.gears_;
        }

        public boolean hasSilverlight() {
            return (this.bitField0_ & 0x2000) == 8192;
        }

        public int getSilverlight() {
            return this.silverlight_;
        }

        public boolean hasCookie() {
            return (this.bitField0_ & 0x4000) == 16384;
        }

        public int getCookie() {
            return this.cookie_;
        }

        private void initFields() {
            this.id_ = ByteString.EMPTY;
            this.os_ = "";
            this.browserName_ = "";
            this.browserVersion_ = "";
            this.resolution_ = "";
            this.pdf_ = 0;
            this.flash_ = 0;
            this.java_ = 0;
            this.director_ = 0;
            this.quicktime_ = 0;
            this.realplayer_ = 0;
            this.windowsmedia_ = 0;
            this.gears_ = 0;
            this.silverlight_ = 0;
            this.cookie_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasId()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasOs()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBrowserName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBrowserVersion()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasResolution()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasPdf()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFlash()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasJava()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasDirector()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasQuicktime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasRealplayer()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasWindowsmedia()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasGears()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasSilverlight()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCookie()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, this.id_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getOsBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getBrowserNameBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(4, getBrowserVersionBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeBytes(5, getResolutionBytes());
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(6, this.pdf_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(7, this.flash_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeInt32(8, this.java_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeInt32(9, this.director_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                output.writeInt32(10, this.quicktime_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                output.writeInt32(11, this.realplayer_);
            }
            if ((this.bitField0_ & 0x800) == 2048) {
                output.writeInt32(12, this.windowsmedia_);
            }
            if ((this.bitField0_ & 0x1000) == 4096) {
                output.writeInt32(13, this.gears_);
            }
            if ((this.bitField0_ & 0x2000) == 8192) {
                output.writeInt32(14, this.silverlight_);
            }
            if ((this.bitField0_ & 0x4000) == 16384) {
                output.writeInt32(15, this.cookie_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeBytesSize(1, this.id_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size = size + CodedOutputStream.computeBytesSize(2, getOsBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size = size + CodedOutputStream.computeBytesSize(3, getBrowserNameBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size = size + CodedOutputStream.computeBytesSize(4, getBrowserVersionBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size = size + CodedOutputStream.computeBytesSize(5, getResolutionBytes());
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size = size + CodedOutputStream.computeInt32Size(6, this.pdf_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size = size + CodedOutputStream.computeInt32Size(7, this.flash_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size = size + CodedOutputStream.computeInt32Size(8, this.java_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size = size + CodedOutputStream.computeInt32Size(9, this.director_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                size = size + CodedOutputStream.computeInt32Size(10, this.quicktime_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                size = size + CodedOutputStream.computeInt32Size(11, this.realplayer_);
            }
            if ((this.bitField0_ & 0x800) == 2048) {
                size = size + CodedOutputStream.computeInt32Size(12, this.windowsmedia_);
            }
            if ((this.bitField0_ & 0x1000) == 4096) {
                size = size + CodedOutputStream.computeInt32Size(13, this.gears_);
            }
            if ((this.bitField0_ & 0x2000) == 8192) {
                size = size + CodedOutputStream.computeInt32Size(14, this.silverlight_);
            }
            if ((this.bitField0_ & 0x4000) == 16384) {
                size = size + CodedOutputStream.computeInt32Size(15, this.cookie_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Config parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Config) PARSER.parseFrom(data);
        }

        public static Config parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Config) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Config parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Config) PARSER.parseFrom(data);
        }

        public static Config parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Config) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Config parseFrom(InputStream input) throws IOException {
            return (Config) PARSER.parseFrom(input);
        }

        public static Config parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Config) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Config parseDelimitedFrom(InputStream input) throws IOException {
            return (Config) PARSER.parseDelimitedFrom(input);
        }

        public static Config parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Config) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Config parseFrom(CodedInputStream input) throws IOException {
            return (Config) PARSER.parseFrom(input);
        }

        public static Config parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Config) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Config prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.ConfigOrBuilder {
            private int bitField0_;
            private ByteString id_ = ByteString.EMPTY;

            private Object os_ = "";

            private Object browserName_ = "";

            private Object browserVersion_ = "";

            private Object resolution_ = "";
            private int pdf_;
            private int flash_;
            private int java_;
            private int director_;
            private int quicktime_;
            private int realplayer_;
            private int windowsmedia_;
            private int gears_;
            private int silverlight_;
            private int cookie_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_Config_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_Config_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.Config.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                WebMsgProto.Config.newBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.id_ = ByteString.EMPTY;
                this.bitField0_ &= -2;
                this.os_ = "";
                this.bitField0_ &= -3;
                this.browserName_ = "";
                this.bitField0_ &= -5;
                this.browserVersion_ = "";
                this.bitField0_ &= -9;
                this.resolution_ = "";
                this.bitField0_ &= -17;
                this.pdf_ = 0;
                this.bitField0_ &= -33;
                this.flash_ = 0;
                this.bitField0_ &= -65;
                this.java_ = 0;
                this.bitField0_ &= -129;
                this.director_ = 0;
                this.bitField0_ &= -257;
                this.quicktime_ = 0;
                this.bitField0_ &= -513;
                this.realplayer_ = 0;
                this.bitField0_ &= -1025;
                this.windowsmedia_ = 0;
                this.bitField0_ &= -2049;
                this.gears_ = 0;
                this.bitField0_ &= -4097;
                this.silverlight_ = 0;
                this.bitField0_ &= -8193;
                this.cookie_ = 0;
                this.bitField0_ &= -16385;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_Config_descriptor;
            }

            public WebMsgProto.Config getDefaultInstanceForType() {
                return WebMsgProto.Config.getDefaultInstance();
            }

            public WebMsgProto.Config build() {
                WebMsgProto.Config result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.Config buildPartial() {
                WebMsgProto.Config result = new WebMsgProto.Config(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.id_ = this.id_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.os_ = this.os_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.browserName_ = this.browserName_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.browserVersion_ = this.browserVersion_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 16;
                }
                result.resolution_ = this.resolution_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 32;
                }
                result.pdf_ = this.pdf_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 64;
                }
                result.flash_ = this.flash_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 128;
                }
                result.java_ = this.java_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 256;
                }
                result.director_ = this.director_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 512;
                }
                result.quicktime_ = this.quicktime_;
                if ((from_bitField0_ & 0x400) == 1024) {
                    to_bitField0_ |= 1024;
                }
                result.realplayer_ = this.realplayer_;
                if ((from_bitField0_ & 0x800) == 2048) {
                    to_bitField0_ |= 2048;
                }
                result.windowsmedia_ = this.windowsmedia_;
                if ((from_bitField0_ & 0x1000) == 4096) {
                    to_bitField0_ |= 4096;
                }
                result.gears_ = this.gears_;
                if ((from_bitField0_ & 0x2000) == 8192) {
                    to_bitField0_ |= 8192;
                }
                result.silverlight_ = this.silverlight_;
                if ((from_bitField0_ & 0x4000) == 16384) {
                    to_bitField0_ |= 16384;
                }
                result.cookie_ = this.cookie_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.Config)) {
                    return mergeFrom((WebMsgProto.Config) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.Config other) {
                if (other == WebMsgProto.Config.getDefaultInstance())
                    return this;
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (other.hasOs()) {
                    this.bitField0_ |= 2;
                    this.os_ = other.os_;
                    onChanged();
                }
                if (other.hasBrowserName()) {
                    this.bitField0_ |= 4;
                    this.browserName_ = other.browserName_;
                    onChanged();
                }
                if (other.hasBrowserVersion()) {
                    this.bitField0_ |= 8;
                    this.browserVersion_ = other.browserVersion_;
                    onChanged();
                }
                if (other.hasResolution()) {
                    this.bitField0_ |= 16;
                    this.resolution_ = other.resolution_;
                    onChanged();
                }
                if (other.hasPdf()) {
                    setPdf(other.getPdf());
                }
                if (other.hasFlash()) {
                    setFlash(other.getFlash());
                }
                if (other.hasJava()) {
                    setJava(other.getJava());
                }
                if (other.hasDirector()) {
                    setDirector(other.getDirector());
                }
                if (other.hasQuicktime()) {
                    setQuicktime(other.getQuicktime());
                }
                if (other.hasRealplayer()) {
                    setRealplayer(other.getRealplayer());
                }
                if (other.hasWindowsmedia()) {
                    setWindowsmedia(other.getWindowsmedia());
                }
                if (other.hasGears()) {
                    setGears(other.getGears());
                }
                if (other.hasSilverlight()) {
                    setSilverlight(other.getSilverlight());
                }
                if (other.hasCookie()) {
                    setCookie(other.getCookie());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                if (!hasOs()) {
                    return false;
                }
                if (!hasBrowserName()) {
                    return false;
                }
                if (!hasBrowserVersion()) {
                    return false;
                }
                if (!hasResolution()) {
                    return false;
                }
                if (!hasPdf()) {
                    return false;
                }
                if (!hasFlash()) {
                    return false;
                }
                if (!hasJava()) {
                    return false;
                }
                if (!hasDirector()) {
                    return false;
                }
                if (!hasQuicktime()) {
                    return false;
                }
                if (!hasRealplayer()) {
                    return false;
                }
                if (!hasWindowsmedia()) {
                    return false;
                }
                if (!hasGears()) {
                    return false;
                }
                if (!hasSilverlight()) {
                    return false;
                }
                if (!hasCookie()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.Config parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.Config) WebMsgProto.Config.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.Config) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasId() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public ByteString getId() {
                return this.id_;
            }

            public Builder setId(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= -2;
                this.id_ = WebMsgProto.Config.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public boolean hasOs() {
                return (this.bitField0_ & 0x2) == 2;
            }

            public String getOs() {
                Object ref = this.os_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.os_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getOsBytes() {
                Object ref = this.os_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.os_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setOs(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.os_ = value;
                onChanged();
                return this;
            }

            public Builder clearOs() {
                this.bitField0_ &= -3;
                this.os_ = WebMsgProto.Config.getDefaultInstance().getOs();
                onChanged();
                return this;
            }

            public Builder setOsBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.os_ = value;
                onChanged();
                return this;
            }

            public boolean hasBrowserName() {
                return (this.bitField0_ & 0x4) == 4;
            }

            public String getBrowserName() {
                Object ref = this.browserName_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.browserName_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getBrowserNameBytes() {
                Object ref = this.browserName_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.browserName_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setBrowserName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.browserName_ = value;
                onChanged();
                return this;
            }

            public Builder clearBrowserName() {
                this.bitField0_ &= -5;
                this.browserName_ = WebMsgProto.Config.getDefaultInstance().getBrowserName();
                onChanged();
                return this;
            }

            public Builder setBrowserNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.browserName_ = value;
                onChanged();
                return this;
            }

            public boolean hasBrowserVersion() {
                return (this.bitField0_ & 0x8) == 8;
            }

            public String getBrowserVersion() {
                Object ref = this.browserVersion_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.browserVersion_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getBrowserVersionBytes() {
                Object ref = this.browserVersion_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.browserVersion_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setBrowserVersion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.browserVersion_ = value;
                onChanged();
                return this;
            }

            public Builder clearBrowserVersion() {
                this.bitField0_ &= -9;
                this.browserVersion_ = WebMsgProto.Config.getDefaultInstance().getBrowserVersion();
                onChanged();
                return this;
            }

            public Builder setBrowserVersionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.browserVersion_ = value;
                onChanged();
                return this;
            }

            public boolean hasResolution() {
                return (this.bitField0_ & 0x10) == 16;
            }

            public String getResolution() {
                Object ref = this.resolution_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.resolution_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getResolutionBytes() {
                Object ref = this.resolution_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.resolution_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setResolution(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.resolution_ = value;
                onChanged();
                return this;
            }

            public Builder clearResolution() {
                this.bitField0_ &= -17;
                this.resolution_ = WebMsgProto.Config.getDefaultInstance().getResolution();
                onChanged();
                return this;
            }

            public Builder setResolutionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.resolution_ = value;
                onChanged();
                return this;
            }

            public boolean hasPdf() {
                return (this.bitField0_ & 0x20) == 32;
            }

            public int getPdf() {
                return this.pdf_;
            }

            public Builder setPdf(int value) {
                this.bitField0_ |= 32;
                this.pdf_ = value;
                onChanged();
                return this;
            }

            public Builder clearPdf() {
                this.bitField0_ &= -33;
                this.pdf_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFlash() {
                return (this.bitField0_ & 0x40) == 64;
            }

            public int getFlash() {
                return this.flash_;
            }

            public Builder setFlash(int value) {
                this.bitField0_ |= 64;
                this.flash_ = value;
                onChanged();
                return this;
            }

            public Builder clearFlash() {
                this.bitField0_ &= -65;
                this.flash_ = 0;
                onChanged();
                return this;
            }

            public boolean hasJava() {
                return (this.bitField0_ & 0x80) == 128;
            }

            public int getJava() {
                return this.java_;
            }

            public Builder setJava(int value) {
                this.bitField0_ |= 128;
                this.java_ = value;
                onChanged();
                return this;
            }

            public Builder clearJava() {
                this.bitField0_ &= -129;
                this.java_ = 0;
                onChanged();
                return this;
            }

            public boolean hasDirector() {
                return (this.bitField0_ & 0x100) == 256;
            }

            public int getDirector() {
                return this.director_;
            }

            public Builder setDirector(int value) {
                this.bitField0_ |= 256;
                this.director_ = value;
                onChanged();
                return this;
            }

            public Builder clearDirector() {
                this.bitField0_ &= -257;
                this.director_ = 0;
                onChanged();
                return this;
            }

            public boolean hasQuicktime() {
                return (this.bitField0_ & 0x200) == 512;
            }

            public int getQuicktime() {
                return this.quicktime_;
            }

            public Builder setQuicktime(int value) {
                this.bitField0_ |= 512;
                this.quicktime_ = value;
                onChanged();
                return this;
            }

            public Builder clearQuicktime() {
                this.bitField0_ &= -513;
                this.quicktime_ = 0;
                onChanged();
                return this;
            }

            public boolean hasRealplayer() {
                return (this.bitField0_ & 0x400) == 1024;
            }

            public int getRealplayer() {
                return this.realplayer_;
            }

            public Builder setRealplayer(int value) {
                this.bitField0_ |= 1024;
                this.realplayer_ = value;
                onChanged();
                return this;
            }

            public Builder clearRealplayer() {
                this.bitField0_ &= -1025;
                this.realplayer_ = 0;
                onChanged();
                return this;
            }

            public boolean hasWindowsmedia() {
                return (this.bitField0_ & 0x800) == 2048;
            }

            public int getWindowsmedia() {
                return this.windowsmedia_;
            }

            public Builder setWindowsmedia(int value) {
                this.bitField0_ |= 2048;
                this.windowsmedia_ = value;
                onChanged();
                return this;
            }

            public Builder clearWindowsmedia() {
                this.bitField0_ &= -2049;
                this.windowsmedia_ = 0;
                onChanged();
                return this;
            }

            public boolean hasGears() {
                return (this.bitField0_ & 0x1000) == 4096;
            }

            public int getGears() {
                return this.gears_;
            }

            public Builder setGears(int value) {
                this.bitField0_ |= 4096;
                this.gears_ = value;
                onChanged();
                return this;
            }

            public Builder clearGears() {
                this.bitField0_ &= -4097;
                this.gears_ = 0;
                onChanged();
                return this;
            }

            public boolean hasSilverlight() {
                return (this.bitField0_ & 0x2000) == 8192;
            }

            public int getSilverlight() {
                return this.silverlight_;
            }

            public Builder setSilverlight(int value) {
                this.bitField0_ |= 8192;
                this.silverlight_ = value;
                onChanged();
                return this;
            }

            public Builder clearSilverlight() {
                this.bitField0_ &= -8193;
                this.silverlight_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCookie() {
                return (this.bitField0_ & 0x4000) == 16384;
            }

            public int getCookie() {
                return this.cookie_;
            }

            public Builder setCookie(int value) {
                this.bitField0_ |= 16384;
                this.cookie_ = value;
                onChanged();
                return this;
            }

            public Builder clearCookie() {
                this.bitField0_ &= -16385;
                this.cookie_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static abstract interface ConfigOrBuilder extends MessageOrBuilder {
        public abstract boolean hasId();

        public abstract ByteString getId();

        public abstract boolean hasOs();

        public abstract String getOs();

        public abstract ByteString getOsBytes();

        public abstract boolean hasBrowserName();

        public abstract String getBrowserName();

        public abstract ByteString getBrowserNameBytes();

        public abstract boolean hasBrowserVersion();

        public abstract String getBrowserVersion();

        public abstract ByteString getBrowserVersionBytes();

        public abstract boolean hasResolution();

        public abstract String getResolution();

        public abstract ByteString getResolutionBytes();

        public abstract boolean hasPdf();

        public abstract int getPdf();

        public abstract boolean hasFlash();

        public abstract int getFlash();

        public abstract boolean hasJava();

        public abstract int getJava();

        public abstract boolean hasDirector();

        public abstract int getDirector();

        public abstract boolean hasQuicktime();

        public abstract int getQuicktime();

        public abstract boolean hasRealplayer();

        public abstract int getRealplayer();

        public abstract boolean hasWindowsmedia();

        public abstract int getWindowsmedia();

        public abstract boolean hasGears();

        public abstract int getGears();

        public abstract boolean hasSilverlight();

        public abstract int getSilverlight();

        public abstract boolean hasCookie();

        public abstract int getCookie();
    }

    public static final class KVPair extends GeneratedMessage implements WebMsgProto.KVPairOrBuilder {
        private static final KVPair defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<KVPair> PARSER = new AbstractParser() {
            public WebMsgProto.KVPair parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.KVPair(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int KEY_FIELD_NUMBER = 1;
        private Object key_;
        public static final int VALUE_FIELD_NUMBER = 2;
        private Object value_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new KVPair(true);
            defaultInstance.initFields();
        }

        private KVPair(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private KVPair(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static KVPair getDefaultInstance() {
            return defaultInstance;
        }

        public KVPair getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private KVPair(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.key_ = input.readBytes();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.value_ = input.readBytes();
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_KVPair_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_KVPair_fieldAccessorTable.ensureFieldAccessorsInitialized(KVPair.class, Builder.class);
        }

        public Parser<KVPair> getParserForType() {
            return PARSER;
        }

        public boolean hasKey() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public String getKey() {
            Object ref = this.key_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.key_ = s;
            }
            return s;
        }

        public ByteString getKeyBytes() {
            Object ref = this.key_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.key_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasValue() {
            return (this.bitField0_ & 0x2) == 2;
        }

        public String getValue() {
            Object ref = this.value_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.value_ = s;
            }
            return s;
        }

        public ByteString getValueBytes() {
            Object ref = this.value_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.value_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.key_ = "";
            this.value_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasKey()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasValue()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getKeyBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getValueBytes());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeBytesSize(1, getKeyBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size = size + CodedOutputStream.computeBytesSize(2, getValueBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static KVPair parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (KVPair) PARSER.parseFrom(data);
        }

        public static KVPair parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (KVPair) PARSER.parseFrom(data, extensionRegistry);
        }

        public static KVPair parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (KVPair) PARSER.parseFrom(data);
        }

        public static KVPair parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (KVPair) PARSER.parseFrom(data, extensionRegistry);
        }

        public static KVPair parseFrom(InputStream input) throws IOException {
            return (KVPair) PARSER.parseFrom(input);
        }

        public static KVPair parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (KVPair) PARSER.parseFrom(input, extensionRegistry);
        }

        public static KVPair parseDelimitedFrom(InputStream input) throws IOException {
            return (KVPair) PARSER.parseDelimitedFrom(input);
        }

        public static KVPair parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (KVPair) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static KVPair parseFrom(CodedInputStream input) throws IOException {
            return (KVPair) PARSER.parseFrom(input);
        }

        public static KVPair parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (KVPair) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(KVPair prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.KVPairOrBuilder {
            private int bitField0_;
            private Object key_ = "";

            private Object value_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_KVPair_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_KVPair_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.KVPair.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                WebMsgProto.KVPair.newBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.key_ = "";
                this.bitField0_ &= -2;
                this.value_ = "";
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_KVPair_descriptor;
            }

            public WebMsgProto.KVPair getDefaultInstanceForType() {
                return WebMsgProto.KVPair.getDefaultInstance();
            }

            public WebMsgProto.KVPair build() {
                WebMsgProto.KVPair result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.KVPair buildPartial() {
                WebMsgProto.KVPair result = new WebMsgProto.KVPair(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.key_ = this.key_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.value_ = this.value_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.KVPair)) {
                    return mergeFrom((WebMsgProto.KVPair) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.KVPair other) {
                if (other == WebMsgProto.KVPair.getDefaultInstance())
                    return this;
                if (other.hasKey()) {
                    this.bitField0_ |= 1;
                    this.key_ = other.key_;
                    onChanged();
                }
                if (other.hasValue()) {
                    this.bitField0_ |= 2;
                    this.value_ = other.value_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasKey()) {
                    return false;
                }
                if (!hasValue()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.KVPair parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.KVPair) WebMsgProto.KVPair.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.KVPair) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasKey() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public String getKey() {
                Object ref = this.key_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.key_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getKeyBytes() {
                Object ref = this.key_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.key_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.key_ = value;
                onChanged();
                return this;
            }

            public Builder clearKey() {
                this.bitField0_ &= -2;
                this.key_ = WebMsgProto.KVPair.getDefaultInstance().getKey();
                onChanged();
                return this;
            }

            public Builder setKeyBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.key_ = value;
                onChanged();
                return this;
            }

            public boolean hasValue() {
                return (this.bitField0_ & 0x2) == 2;
            }

            public String getValue() {
                Object ref = this.value_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.value_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getValueBytes() {
                Object ref = this.value_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.value_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.value_ = value;
                onChanged();
                return this;
            }

            public Builder clearValue() {
                this.bitField0_ &= -3;
                this.value_ = WebMsgProto.KVPair.getDefaultInstance().getValue();
                onChanged();
                return this;
            }

            public Builder setValueBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.value_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static abstract interface KVPairOrBuilder extends MessageOrBuilder {
        public abstract boolean hasKey();

        public abstract String getKey();

        public abstract ByteString getKeyBytes();

        public abstract boolean hasValue();

        public abstract String getValue();

        public abstract ByteString getValueBytes();
    }

    public static final class LinkVisitActionItem extends GeneratedMessage implements WebMsgProto.LinkVisitActionItemOrBuilder {
        private static final LinkVisitActionItem defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<LinkVisitActionItem> PARSER = new AbstractParser() {
            public WebMsgProto.LinkVisitActionItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.LinkVisitActionItem(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int IDLINK_VA_FIELD_NUMBER = 1;
        private int idlinkVa_;
        public static final int IDSITE_FIELD_NUMBER = 2;
        private int idsite_;
        public static final int IDVISITOR_FIELD_NUMBER = 3;
        private ByteString idvisitor_;
        public static final int SERVER_TIME_FIELD_NUMBER = 4;
        private long serverTime_;
        public static final int IDVISIT_FIELD_NUMBER = 5;
        private int idvisit_;
        public static final int IDACTION_URL_FIELD_NUMBER = 6;
        private int idactionUrl_;
        public static final int IDACTION_URL_REF_FIELD_NUMBER = 7;
        private int idactionUrlRef_;
        public static final int IDACTION_NAME_FIELD_NUMBER = 8;
        private int idactionName_;
        public static final int IDACTION_NAME_REF_FIELD_NUMBER = 9;
        private int idactionNameRef_;
        public static final int TIME_SPENT_REF_ACTION_FIELD_NUMBER = 10;
        private int timeSpentRefAction_;
        public static final int KVPAIR_FIELD_NUMBER = 11;
        private List<WebMsgProto.KVPair> kvpair_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new LinkVisitActionItem(true);
            defaultInstance.initFields();
        }

        private LinkVisitActionItem(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private LinkVisitActionItem(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LinkVisitActionItem getDefaultInstance() {
            return defaultInstance;
        }

        public LinkVisitActionItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LinkVisitActionItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.idlinkVa_ = input.readInt32();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.idsite_ = input.readInt32();
                            break;
                        case 26:
                            this.bitField0_ |= 4;
                            this.idvisitor_ = input.readBytes();
                            break;
                        case 32:
                            this.bitField0_ |= 8;
                            this.serverTime_ = input.readInt64();
                            break;
                        case 40:
                            this.bitField0_ |= 16;
                            this.idvisit_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 32;
                            this.idactionUrl_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 64;
                            this.idactionUrlRef_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 128;
                            this.idactionName_ = input.readInt32();
                            break;
                        case 72:
                            this.bitField0_ |= 256;
                            this.idactionNameRef_ = input.readInt32();
                            break;
                        case 80:
                            this.bitField0_ |= 512;
                            this.timeSpentRefAction_ = input.readInt32();
                            break;
                        case 90:
                            if ((mutable_bitField0_ & 0x400) != 1024) {
                                this.kvpair_ = new ArrayList();
                                mutable_bitField0_ |= 1024;
                            }
                            this.kvpair_.add((WebMsgProto.KVPair) input.readMessage(WebMsgProto.KVPair.PARSER, extensionRegistry));
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x400) == 1024) {
                    this.kvpair_ = Collections.unmodifiableList(this.kvpair_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_LinkVisitActionItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_LinkVisitActionItem_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkVisitActionItem.class, Builder.class);
        }

        public Parser<LinkVisitActionItem> getParserForType() {
            return PARSER;
        }

        public boolean hasIdlinkVa() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public int getIdlinkVa() {
            return this.idlinkVa_;
        }

        public boolean hasIdsite() {
            return (this.bitField0_ & 0x2) == 2;
        }

        public int getIdsite() {
            return this.idsite_;
        }

        public boolean hasIdvisitor() {
            return (this.bitField0_ & 0x4) == 4;
        }

        public ByteString getIdvisitor() {
            return this.idvisitor_;
        }

        public boolean hasServerTime() {
            return (this.bitField0_ & 0x8) == 8;
        }

        public long getServerTime() {
            return this.serverTime_;
        }

        public boolean hasIdvisit() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public int getIdvisit() {
            return this.idvisit_;
        }

        public boolean hasIdactionUrl() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public int getIdactionUrl() {
            return this.idactionUrl_;
        }

        public boolean hasIdactionUrlRef() {
            return (this.bitField0_ & 0x40) == 64;
        }

        public int getIdactionUrlRef() {
            return this.idactionUrlRef_;
        }

        public boolean hasIdactionName() {
            return (this.bitField0_ & 0x80) == 128;
        }

        public int getIdactionName() {
            return this.idactionName_;
        }

        public boolean hasIdactionNameRef() {
            return (this.bitField0_ & 0x100) == 256;
        }

        public int getIdactionNameRef() {
            return this.idactionNameRef_;
        }

        public boolean hasTimeSpentRefAction() {
            return (this.bitField0_ & 0x200) == 512;
        }

        public int getTimeSpentRefAction() {
            return this.timeSpentRefAction_;
        }

        public List<WebMsgProto.KVPair> getKvpairList() {
            return this.kvpair_;
        }

        public List<? extends WebMsgProto.KVPairOrBuilder> getKvpairOrBuilderList() {
            return this.kvpair_;
        }

        public int getKvpairCount() {
            return this.kvpair_.size();
        }

        public WebMsgProto.KVPair getKvpair(int index) {
            return (WebMsgProto.KVPair) this.kvpair_.get(index);
        }

        public WebMsgProto.KVPairOrBuilder getKvpairOrBuilder(int index) {
            return (WebMsgProto.KVPairOrBuilder) this.kvpair_.get(index);
        }

        private void initFields() {
            this.idlinkVa_ = 0;
            this.idsite_ = 0;
            this.idvisitor_ = ByteString.EMPTY;
            this.serverTime_ = 0L;
            this.idvisit_ = 0;
            this.idactionUrl_ = 0;
            this.idactionUrlRef_ = 0;
            this.idactionName_ = 0;
            this.idactionNameRef_ = 0;
            this.timeSpentRefAction_ = 0;
            this.kvpair_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasIdlinkVa()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIdsite()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIdvisitor()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasServerTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIdvisit()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIdactionUrl()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIdactionUrlRef()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIdactionName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIdactionNameRef()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTimeSpentRefAction()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getKvpairCount(); i++) {
                if (!getKvpair(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.idlinkVa_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.idsite_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, this.idvisitor_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt64(4, this.serverTime_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.idvisit_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(6, this.idactionUrl_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(7, this.idactionUrlRef_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeInt32(8, this.idactionName_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeInt32(9, this.idactionNameRef_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                output.writeInt32(10, this.timeSpentRefAction_);
            }
            for (int i = 0; i < this.kvpair_.size(); i++) {
                output.writeMessage(11, (MessageLite) this.kvpair_.get(i));
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeInt32Size(1, this.idlinkVa_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size = size + CodedOutputStream.computeInt32Size(2, this.idsite_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size = size + CodedOutputStream.computeBytesSize(3, this.idvisitor_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size = size + CodedOutputStream.computeInt64Size(4, this.serverTime_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size = size + CodedOutputStream.computeInt32Size(5, this.idvisit_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size = size + CodedOutputStream.computeInt32Size(6, this.idactionUrl_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size = size + CodedOutputStream.computeInt32Size(7, this.idactionUrlRef_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size = size + CodedOutputStream.computeInt32Size(8, this.idactionName_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size = size + CodedOutputStream.computeInt32Size(9, this.idactionNameRef_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                size = size + CodedOutputStream.computeInt32Size(10, this.timeSpentRefAction_);
            }
            for (int i = 0; i < this.kvpair_.size(); i++) {
                size = size + CodedOutputStream.computeMessageSize(11, (MessageLite) this.kvpair_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LinkVisitActionItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LinkVisitActionItem) PARSER.parseFrom(data);
        }

        public static LinkVisitActionItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LinkVisitActionItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LinkVisitActionItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LinkVisitActionItem) PARSER.parseFrom(data);
        }

        public static LinkVisitActionItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LinkVisitActionItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LinkVisitActionItem parseFrom(InputStream input) throws IOException {
            return (LinkVisitActionItem) PARSER.parseFrom(input);
        }

        public static LinkVisitActionItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LinkVisitActionItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LinkVisitActionItem parseDelimitedFrom(InputStream input) throws IOException {
            return (LinkVisitActionItem) PARSER.parseDelimitedFrom(input);
        }

        public static LinkVisitActionItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LinkVisitActionItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LinkVisitActionItem parseFrom(CodedInputStream input) throws IOException {
            return (LinkVisitActionItem) PARSER.parseFrom(input);
        }

        public static LinkVisitActionItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LinkVisitActionItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LinkVisitActionItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.LinkVisitActionItemOrBuilder {
            private int bitField0_;
            private int idlinkVa_;
            private int idsite_;
            private ByteString idvisitor_ = ByteString.EMPTY;
            private long serverTime_;
            private int idvisit_;
            private int idactionUrl_;
            private int idactionUrlRef_;
            private int idactionName_;
            private int idactionNameRef_;
            private int timeSpentRefAction_;
            private List<WebMsgProto.KVPair> kvpair_ = Collections.emptyList();
            private RepeatedFieldBuilder<WebMsgProto.KVPair, WebMsgProto.KVPair.Builder, WebMsgProto.KVPairOrBuilder> kvpairBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_LinkVisitActionItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_LinkVisitActionItem_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.LinkVisitActionItem.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WebMsgProto.LinkVisitActionItem.alwaysUseFieldBuilders)
                    getKvpairFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.idlinkVa_ = 0;
                this.bitField0_ &= -2;
                this.idsite_ = 0;
                this.bitField0_ &= -3;
                this.idvisitor_ = ByteString.EMPTY;
                this.bitField0_ &= -5;
                this.serverTime_ = 0L;
                this.bitField0_ &= -9;
                this.idvisit_ = 0;
                this.bitField0_ &= -17;
                this.idactionUrl_ = 0;
                this.bitField0_ &= -33;
                this.idactionUrlRef_ = 0;
                this.bitField0_ &= -65;
                this.idactionName_ = 0;
                this.bitField0_ &= -129;
                this.idactionNameRef_ = 0;
                this.bitField0_ &= -257;
                this.timeSpentRefAction_ = 0;
                this.bitField0_ &= -513;
                if (this.kvpairBuilder_ == null) {
                    this.kvpair_ = Collections.emptyList();
                    this.bitField0_ &= -1025;
                } else {
                    this.kvpairBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_LinkVisitActionItem_descriptor;
            }

            public WebMsgProto.LinkVisitActionItem getDefaultInstanceForType() {
                return WebMsgProto.LinkVisitActionItem.getDefaultInstance();
            }

            public WebMsgProto.LinkVisitActionItem build() {
                WebMsgProto.LinkVisitActionItem result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.LinkVisitActionItem buildPartial() {
                WebMsgProto.LinkVisitActionItem result = new WebMsgProto.LinkVisitActionItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.idlinkVa_ = this.idlinkVa_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.idsite_ = this.idsite_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.idvisitor_ = this.idvisitor_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.serverTime_ = this.serverTime_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 16;
                }
                result.idvisit_ = this.idvisit_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 32;
                }
                result.idactionUrl_ = this.idactionUrl_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 64;
                }
                result.idactionUrlRef_ = this.idactionUrlRef_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 128;
                }
                result.idactionName_ = this.idactionName_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 256;
                }
                result.idactionNameRef_ = this.idactionNameRef_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 512;
                }
                result.timeSpentRefAction_ = this.timeSpentRefAction_;
                if (this.kvpairBuilder_ == null) {
                    if ((this.bitField0_ & 0x400) == 1024) {
                        this.kvpair_ = Collections.unmodifiableList(this.kvpair_);
                        this.bitField0_ &= -1025;
                    }
                    result.kvpair_ = this.kvpair_;
                } else {
                    result.kvpair_ = this.kvpairBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.LinkVisitActionItem)) {
                    return mergeFrom((WebMsgProto.LinkVisitActionItem) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.LinkVisitActionItem other) {
                if (other == WebMsgProto.LinkVisitActionItem.getDefaultInstance())
                    return this;
                if (other.hasIdlinkVa()) {
                    setIdlinkVa(other.getIdlinkVa());
                }
                if (other.hasIdsite()) {
                    setIdsite(other.getIdsite());
                }
                if (other.hasIdvisitor()) {
                    setIdvisitor(other.getIdvisitor());
                }
                if (other.hasServerTime()) {
                    setServerTime(other.getServerTime());
                }
                if (other.hasIdvisit()) {
                    setIdvisit(other.getIdvisit());
                }
                if (other.hasIdactionUrl()) {
                    setIdactionUrl(other.getIdactionUrl());
                }
                if (other.hasIdactionUrlRef()) {
                    setIdactionUrlRef(other.getIdactionUrlRef());
                }
                if (other.hasIdactionName()) {
                    setIdactionName(other.getIdactionName());
                }
                if (other.hasIdactionNameRef()) {
                    setIdactionNameRef(other.getIdactionNameRef());
                }
                if (other.hasTimeSpentRefAction()) {
                    setTimeSpentRefAction(other.getTimeSpentRefAction());
                }
                if (this.kvpairBuilder_ == null) {
                    if (!other.kvpair_.isEmpty()) {
                        if (this.kvpair_.isEmpty()) {
                            this.kvpair_ = other.kvpair_;
                            this.bitField0_ &= -1025;
                        } else {
                            ensureKvpairIsMutable();
                            this.kvpair_.addAll(other.kvpair_);
                        }
                        onChanged();
                    }
                } else if (!other.kvpair_.isEmpty()) {
                    if (this.kvpairBuilder_.isEmpty()) {
                        this.kvpairBuilder_.dispose();
                        this.kvpairBuilder_ = null;
                        this.kvpair_ = other.kvpair_;
                        this.bitField0_ &= -1025;
                        this.kvpairBuilder_ = (WebMsgProto.LinkVisitActionItem.alwaysUseFieldBuilders ? getKvpairFieldBuilder() : null);
                    } else {
                        this.kvpairBuilder_.addAllMessages(other.kvpair_);
                    }
                }

                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasIdlinkVa()) {
                    return false;
                }
                if (!hasIdsite()) {
                    return false;
                }
                if (!hasIdvisitor()) {
                    return false;
                }
                if (!hasServerTime()) {
                    return false;
                }
                if (!hasIdvisit()) {
                    return false;
                }
                if (!hasIdactionUrl()) {
                    return false;
                }
                if (!hasIdactionUrlRef()) {
                    return false;
                }
                if (!hasIdactionName()) {
                    return false;
                }
                if (!hasIdactionNameRef()) {
                    return false;
                }
                if (!hasTimeSpentRefAction()) {
                    return false;
                }
                for (int i = 0; i < getKvpairCount(); i++) {
                    if (!getKvpair(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.LinkVisitActionItem parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.LinkVisitActionItem) WebMsgProto.LinkVisitActionItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.LinkVisitActionItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasIdlinkVa() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public int getIdlinkVa() {
                return this.idlinkVa_;
            }

            public Builder setIdlinkVa(int value) {
                this.bitField0_ |= 1;
                this.idlinkVa_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdlinkVa() {
                this.bitField0_ &= -2;
                this.idlinkVa_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIdsite() {
                return (this.bitField0_ & 0x2) == 2;
            }

            public int getIdsite() {
                return this.idsite_;
            }

            public Builder setIdsite(int value) {
                this.bitField0_ |= 2;
                this.idsite_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdsite() {
                this.bitField0_ &= -3;
                this.idsite_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIdvisitor() {
                return (this.bitField0_ & 0x4) == 4;
            }

            public ByteString getIdvisitor() {
                return this.idvisitor_;
            }

            public Builder setIdvisitor(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.idvisitor_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdvisitor() {
                this.bitField0_ &= -5;
                this.idvisitor_ = WebMsgProto.LinkVisitActionItem.getDefaultInstance().getIdvisitor();
                onChanged();
                return this;
            }

            public boolean hasServerTime() {
                return (this.bitField0_ & 0x8) == 8;
            }

            public long getServerTime() {
                return this.serverTime_;
            }

            public Builder setServerTime(long value) {
                this.bitField0_ |= 8;
                this.serverTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearServerTime() {
                this.bitField0_ &= -9;
                this.serverTime_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasIdvisit() {
                return (this.bitField0_ & 0x10) == 16;
            }

            public int getIdvisit() {
                return this.idvisit_;
            }

            public Builder setIdvisit(int value) {
                this.bitField0_ |= 16;
                this.idvisit_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdvisit() {
                this.bitField0_ &= -17;
                this.idvisit_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIdactionUrl() {
                return (this.bitField0_ & 0x20) == 32;
            }

            public int getIdactionUrl() {
                return this.idactionUrl_;
            }

            public Builder setIdactionUrl(int value) {
                this.bitField0_ |= 32;
                this.idactionUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdactionUrl() {
                this.bitField0_ &= -33;
                this.idactionUrl_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIdactionUrlRef() {
                return (this.bitField0_ & 0x40) == 64;
            }

            public int getIdactionUrlRef() {
                return this.idactionUrlRef_;
            }

            public Builder setIdactionUrlRef(int value) {
                this.bitField0_ |= 64;
                this.idactionUrlRef_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdactionUrlRef() {
                this.bitField0_ &= -65;
                this.idactionUrlRef_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIdactionName() {
                return (this.bitField0_ & 0x80) == 128;
            }

            public int getIdactionName() {
                return this.idactionName_;
            }

            public Builder setIdactionName(int value) {
                this.bitField0_ |= 128;
                this.idactionName_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdactionName() {
                this.bitField0_ &= -129;
                this.idactionName_ = 0;
                onChanged();
                return this;
            }

            public boolean hasIdactionNameRef() {
                return (this.bitField0_ & 0x100) == 256;
            }

            public int getIdactionNameRef() {
                return this.idactionNameRef_;
            }

            public Builder setIdactionNameRef(int value) {
                this.bitField0_ |= 256;
                this.idactionNameRef_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdactionNameRef() {
                this.bitField0_ &= -257;
                this.idactionNameRef_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTimeSpentRefAction() {
                return (this.bitField0_ & 0x200) == 512;
            }

            public int getTimeSpentRefAction() {
                return this.timeSpentRefAction_;
            }

            public Builder setTimeSpentRefAction(int value) {
                this.bitField0_ |= 512;
                this.timeSpentRefAction_ = value;
                onChanged();
                return this;
            }

            public Builder clearTimeSpentRefAction() {
                this.bitField0_ &= -513;
                this.timeSpentRefAction_ = 0;
                onChanged();
                return this;
            }

            private void ensureKvpairIsMutable() {
                if ((this.bitField0_ & 0x400) != 1024) {
                    this.kvpair_ = new ArrayList(this.kvpair_);
                    this.bitField0_ |= 1024;
                }
            }

            public List<WebMsgProto.KVPair> getKvpairList() {
                if (this.kvpairBuilder_ == null) {
                    return Collections.unmodifiableList(this.kvpair_);
                }
                return this.kvpairBuilder_.getMessageList();
            }

            public int getKvpairCount() {
                if (this.kvpairBuilder_ == null) {
                    return this.kvpair_.size();
                }
                return this.kvpairBuilder_.getCount();
            }

            public WebMsgProto.KVPair getKvpair(int index) {
                if (this.kvpairBuilder_ == null) {
                    return (WebMsgProto.KVPair) this.kvpair_.get(index);
                }
                return (WebMsgProto.KVPair) this.kvpairBuilder_.getMessage(index);
            }

            public Builder setKvpair(int index, WebMsgProto.KVPair value) {
                if (this.kvpairBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureKvpairIsMutable();
                    this.kvpair_.set(index, value);
                    onChanged();
                } else {
                    this.kvpairBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setKvpair(int index, WebMsgProto.KVPair.Builder builderForValue) {
                if (this.kvpairBuilder_ == null) {
                    ensureKvpairIsMutable();
                    this.kvpair_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.kvpairBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addKvpair(WebMsgProto.KVPair value) {
                if (this.kvpairBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureKvpairIsMutable();
                    this.kvpair_.add(value);
                    onChanged();
                } else {
                    this.kvpairBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addKvpair(int index, WebMsgProto.KVPair value) {
                if (this.kvpairBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureKvpairIsMutable();
                    this.kvpair_.add(index, value);
                    onChanged();
                } else {
                    this.kvpairBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addKvpair(WebMsgProto.KVPair.Builder builderForValue) {
                if (this.kvpairBuilder_ == null) {
                    ensureKvpairIsMutable();
                    this.kvpair_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.kvpairBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addKvpair(int index, WebMsgProto.KVPair.Builder builderForValue) {
                if (this.kvpairBuilder_ == null) {
                    ensureKvpairIsMutable();
                    this.kvpair_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.kvpairBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllKvpair(Iterable<? extends WebMsgProto.KVPair> values) {
                if (this.kvpairBuilder_ == null) {
                    ensureKvpairIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.kvpair_);
                    onChanged();
                } else {
                    this.kvpairBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearKvpair() {
                if (this.kvpairBuilder_ == null) {
                    this.kvpair_ = Collections.emptyList();
                    this.bitField0_ &= -1025;
                    onChanged();
                } else {
                    this.kvpairBuilder_.clear();
                }
                return this;
            }

            public Builder removeKvpair(int index) {
                if (this.kvpairBuilder_ == null) {
                    ensureKvpairIsMutable();
                    this.kvpair_.remove(index);
                    onChanged();
                } else {
                    this.kvpairBuilder_.remove(index);
                }
                return this;
            }

            public WebMsgProto.KVPair.Builder getKvpairBuilder(int index) {
                return (WebMsgProto.KVPair.Builder) getKvpairFieldBuilder().getBuilder(index);
            }

            public WebMsgProto.KVPairOrBuilder getKvpairOrBuilder(int index) {
                if (this.kvpairBuilder_ == null)
                    return (WebMsgProto.KVPairOrBuilder) this.kvpair_.get(index);
                return (WebMsgProto.KVPairOrBuilder) this.kvpairBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends WebMsgProto.KVPairOrBuilder> getKvpairOrBuilderList() {
                if (this.kvpairBuilder_ != null) {
                    return this.kvpairBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.kvpair_);
            }

            public WebMsgProto.KVPair.Builder addKvpairBuilder() {
                return (WebMsgProto.KVPair.Builder) getKvpairFieldBuilder().addBuilder(WebMsgProto.KVPair.getDefaultInstance());
            }

            public WebMsgProto.KVPair.Builder addKvpairBuilder(int index) {
                return (WebMsgProto.KVPair.Builder) getKvpairFieldBuilder().addBuilder(index, WebMsgProto.KVPair.getDefaultInstance());
            }

            public List<WebMsgProto.KVPair.Builder> getKvpairBuilderList() {
                return getKvpairFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<WebMsgProto.KVPair, WebMsgProto.KVPair.Builder, WebMsgProto.KVPairOrBuilder> getKvpairFieldBuilder() {
                if (this.kvpairBuilder_ == null) {
                    this.kvpairBuilder_ = new RepeatedFieldBuilder(this.kvpair_, (this.bitField0_ & 0x400) == 1024, getParentForChildren(), isClean());
                    this.kvpair_ = null;
                }
                return this.kvpairBuilder_;
            }
        }
    }

    public static abstract interface LinkVisitActionItemOrBuilder extends MessageOrBuilder {
        public abstract boolean hasIdlinkVa();

        public abstract int getIdlinkVa();

        public abstract boolean hasIdsite();

        public abstract int getIdsite();

        public abstract boolean hasIdvisitor();

        public abstract ByteString getIdvisitor();

        public abstract boolean hasServerTime();

        public abstract long getServerTime();

        public abstract boolean hasIdvisit();

        public abstract int getIdvisit();

        public abstract boolean hasIdactionUrl();

        public abstract int getIdactionUrl();

        public abstract boolean hasIdactionUrlRef();

        public abstract int getIdactionUrlRef();

        public abstract boolean hasIdactionName();

        public abstract int getIdactionName();

        public abstract boolean hasIdactionNameRef();

        public abstract int getIdactionNameRef();

        public abstract boolean hasTimeSpentRefAction();

        public abstract int getTimeSpentRefAction();

        public abstract List<WebMsgProto.KVPair> getKvpairList();

        public abstract WebMsgProto.KVPair getKvpair(int paramInt);

        public abstract int getKvpairCount();

        public abstract List<? extends WebMsgProto.KVPairOrBuilder> getKvpairOrBuilderList();

        public abstract WebMsgProto.KVPairOrBuilder getKvpairOrBuilder(int paramInt);
    }

    public static final class Location extends GeneratedMessage implements WebMsgProto.LocationOrBuilder {
        private static final Location defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<Location> PARSER = new AbstractParser() {
            public WebMsgProto.Location parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.Location(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int IP_FIELD_NUMBER = 1;
        private ByteString ip_;
        public static final int BROWSER_LANG_FIELD_NUMBER = 2;
        private Object browserLang_;
        public static final int COUNTRY_FIELD_NUMBER = 3;
        private Object country_;
        public static final int REGION_FIELD_NUMBER = 4;
        private Object region_;
        public static final int CITY_FIELD_NUMBER = 5;
        private Object city_;
        public static final int LATITUDE_FIELD_NUMBER = 6;
        private float latitude_;
        public static final int LOCATION_LONGITUDE_FIELD_NUMBER = 7;
        private float locationLongitude_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new Location(true);
            defaultInstance.initFields();
        }

        private Location(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private Location(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Location getDefaultInstance() {
            return defaultInstance;
        }

        public Location getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Location(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.ip_ = input.readBytes();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.browserLang_ = input.readBytes();
                            break;
                        case 26:
                            this.bitField0_ |= 4;
                            this.country_ = input.readBytes();
                            break;
                        case 34:
                            this.bitField0_ |= 8;
                            this.region_ = input.readBytes();
                            break;
                        case 42:
                            this.bitField0_ |= 16;
                            this.city_ = input.readBytes();
                            break;
                        case 53:
                            this.bitField0_ |= 32;
                            this.latitude_ = input.readFloat();
                            break;
                        case 61:
                            this.bitField0_ |= 64;
                            this.locationLongitude_ = input.readFloat();
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_Location_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_Location_fieldAccessorTable.ensureFieldAccessorsInitialized(Location.class, Builder.class);
        }

        public Parser<Location> getParserForType() {
            return PARSER;
        }

        public boolean hasIp() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public ByteString getIp() {
            return this.ip_;
        }

        public boolean hasBrowserLang() {
            return (this.bitField0_ & 0x2) == 2;
        }

        public String getBrowserLang() {
            Object ref = this.browserLang_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.browserLang_ = s;
            }
            return s;
        }

        public ByteString getBrowserLangBytes() {
            Object ref = this.browserLang_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.browserLang_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasCountry() {
            return (this.bitField0_ & 0x4) == 4;
        }

        public String getCountry() {
            Object ref = this.country_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.country_ = s;
            }
            return s;
        }

        public ByteString getCountryBytes() {
            Object ref = this.country_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.country_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasRegion() {
            return (this.bitField0_ & 0x8) == 8;
        }

        public String getRegion() {
            Object ref = this.region_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.region_ = s;
            }
            return s;
        }

        public ByteString getRegionBytes() {
            Object ref = this.region_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.region_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasCity() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public String getCity() {
            Object ref = this.city_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.city_ = s;
            }
            return s;
        }

        public ByteString getCityBytes() {
            Object ref = this.city_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.city_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasLatitude() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public float getLatitude() {
            return this.latitude_;
        }

        public boolean hasLocationLongitude() {
            return (this.bitField0_ & 0x40) == 64;
        }

        public float getLocationLongitude() {
            return this.locationLongitude_;
        }

        private void initFields() {
            this.ip_ = ByteString.EMPTY;
            this.browserLang_ = "";
            this.country_ = "";
            this.region_ = "";
            this.city_ = "";
            this.latitude_ = 0.0F;
            this.locationLongitude_ = 0.0F;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasIp()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasBrowserLang()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCountry()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasRegion()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCity()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLatitude()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLocationLongitude()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, this.ip_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getBrowserLangBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getCountryBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(4, getRegionBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeBytes(5, getCityBytes());
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeFloat(6, this.latitude_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeFloat(7, this.locationLongitude_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeBytesSize(1, this.ip_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size = size + CodedOutputStream.computeBytesSize(2, getBrowserLangBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size = size + CodedOutputStream.computeBytesSize(3, getCountryBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size = size + CodedOutputStream.computeBytesSize(4, getRegionBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size = size + CodedOutputStream.computeBytesSize(5, getCityBytes());
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size = size + CodedOutputStream.computeFloatSize(6, this.latitude_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size = size + CodedOutputStream.computeFloatSize(7, this.locationLongitude_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Location parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Location) PARSER.parseFrom(data);
        }

        public static Location parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Location) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Location parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Location) PARSER.parseFrom(data);
        }

        public static Location parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Location) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Location parseFrom(InputStream input) throws IOException {
            return (Location) PARSER.parseFrom(input);
        }

        public static Location parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Location) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Location parseDelimitedFrom(InputStream input) throws IOException {
            return (Location) PARSER.parseDelimitedFrom(input);
        }

        public static Location parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Location) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Location parseFrom(CodedInputStream input) throws IOException {
            return (Location) PARSER.parseFrom(input);
        }

        public static Location parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Location) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Location prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.LocationOrBuilder {
            private int bitField0_;
            private ByteString ip_ = ByteString.EMPTY;

            private Object browserLang_ = "";

            private Object country_ = "";

            private Object region_ = "";

            private Object city_ = "";
            private float latitude_;
            private float locationLongitude_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_Location_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_Location_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.Location.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                WebMsgProto.Location.newBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.ip_ = ByteString.EMPTY;
                this.bitField0_ &= -2;
                this.browserLang_ = "";
                this.bitField0_ &= -3;
                this.country_ = "";
                this.bitField0_ &= -5;
                this.region_ = "";
                this.bitField0_ &= -9;
                this.city_ = "";
                this.bitField0_ &= -17;
                this.latitude_ = 0.0F;
                this.bitField0_ &= -33;
                this.locationLongitude_ = 0.0F;
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_Location_descriptor;
            }

            public WebMsgProto.Location getDefaultInstanceForType() {
                return WebMsgProto.Location.getDefaultInstance();
            }

            public WebMsgProto.Location build() {
                WebMsgProto.Location result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.Location buildPartial() {
                WebMsgProto.Location result = new WebMsgProto.Location(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.ip_ = this.ip_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.browserLang_ = this.browserLang_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.country_ = this.country_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.region_ = this.region_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 16;
                }
                result.city_ = this.city_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 32;
                }
                result.latitude_ = this.latitude_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 64;
                }
                result.locationLongitude_ = this.locationLongitude_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.Location)) {
                    return mergeFrom((WebMsgProto.Location) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.Location other) {
                if (other == WebMsgProto.Location.getDefaultInstance())
                    return this;
                if (other.hasIp()) {
                    setIp(other.getIp());
                }
                if (other.hasBrowserLang()) {
                    this.bitField0_ |= 2;
                    this.browserLang_ = other.browserLang_;
                    onChanged();
                }
                if (other.hasCountry()) {
                    this.bitField0_ |= 4;
                    this.country_ = other.country_;
                    onChanged();
                }
                if (other.hasRegion()) {
                    this.bitField0_ |= 8;
                    this.region_ = other.region_;
                    onChanged();
                }
                if (other.hasCity()) {
                    this.bitField0_ |= 16;
                    this.city_ = other.city_;
                    onChanged();
                }
                if (other.hasLatitude()) {
                    setLatitude(other.getLatitude());
                }
                if (other.hasLocationLongitude()) {
                    setLocationLongitude(other.getLocationLongitude());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasIp()) {
                    return false;
                }
                if (!hasBrowserLang()) {
                    return false;
                }
                if (!hasCountry()) {
                    return false;
                }
                if (!hasRegion()) {
                    return false;
                }
                if (!hasCity()) {
                    return false;
                }
                if (!hasLatitude()) {
                    return false;
                }
                if (!hasLocationLongitude()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.Location parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.Location) WebMsgProto.Location.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.Location) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasIp() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public ByteString getIp() {
                return this.ip_;
            }

            public Builder setIp(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.ip_ = value;
                onChanged();
                return this;
            }

            public Builder clearIp() {
                this.bitField0_ &= -2;
                this.ip_ = WebMsgProto.Location.getDefaultInstance().getIp();
                onChanged();
                return this;
            }

            public boolean hasBrowserLang() {
                return (this.bitField0_ & 0x2) == 2;
            }

            public String getBrowserLang() {
                Object ref = this.browserLang_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.browserLang_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getBrowserLangBytes() {
                Object ref = this.browserLang_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.browserLang_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setBrowserLang(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.browserLang_ = value;
                onChanged();
                return this;
            }

            public Builder clearBrowserLang() {
                this.bitField0_ &= -3;
                this.browserLang_ = WebMsgProto.Location.getDefaultInstance().getBrowserLang();
                onChanged();
                return this;
            }

            public Builder setBrowserLangBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.browserLang_ = value;
                onChanged();
                return this;
            }

            public boolean hasCountry() {
                return (this.bitField0_ & 0x4) == 4;
            }

            public String getCountry() {
                Object ref = this.country_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.country_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getCountryBytes() {
                Object ref = this.country_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.country_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setCountry(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.country_ = value;
                onChanged();
                return this;
            }

            public Builder clearCountry() {
                this.bitField0_ &= -5;
                this.country_ = WebMsgProto.Location.getDefaultInstance().getCountry();
                onChanged();
                return this;
            }

            public Builder setCountryBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.country_ = value;
                onChanged();
                return this;
            }

            public boolean hasRegion() {
                return (this.bitField0_ & 0x8) == 8;
            }

            public String getRegion() {
                Object ref = this.region_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.region_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getRegionBytes() {
                Object ref = this.region_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.region_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setRegion(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.region_ = value;
                onChanged();
                return this;
            }

            public Builder clearRegion() {
                this.bitField0_ &= -9;
                this.region_ = WebMsgProto.Location.getDefaultInstance().getRegion();
                onChanged();
                return this;
            }

            public Builder setRegionBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.region_ = value;
                onChanged();
                return this;
            }

            public boolean hasCity() {
                return (this.bitField0_ & 0x10) == 16;
            }

            public String getCity() {
                Object ref = this.city_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.city_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getCityBytes() {
                Object ref = this.city_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.city_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setCity(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.city_ = value;
                onChanged();
                return this;
            }

            public Builder clearCity() {
                this.bitField0_ &= -17;
                this.city_ = WebMsgProto.Location.getDefaultInstance().getCity();
                onChanged();
                return this;
            }

            public Builder setCityBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.city_ = value;
                onChanged();
                return this;
            }

            public boolean hasLatitude() {
                return (this.bitField0_ & 0x20) == 32;
            }

            public float getLatitude() {
                return this.latitude_;
            }

            public Builder setLatitude(float value) {
                this.bitField0_ |= 32;
                this.latitude_ = value;
                onChanged();
                return this;
            }

            public Builder clearLatitude() {
                this.bitField0_ &= -33;
                this.latitude_ = 0.0F;
                onChanged();
                return this;
            }

            public boolean hasLocationLongitude() {
                return (this.bitField0_ & 0x40) == 64;
            }

            public float getLocationLongitude() {
                return this.locationLongitude_;
            }

            public Builder setLocationLongitude(float value) {
                this.bitField0_ |= 64;
                this.locationLongitude_ = value;
                onChanged();
                return this;
            }

            public Builder clearLocationLongitude() {
                this.bitField0_ &= -65;
                this.locationLongitude_ = 0.0F;
                onChanged();
                return this;
            }
        }
    }

    public static final class LocationGeoip extends GeneratedMessage implements WebMsgProto.LocationGeoipOrBuilder {
        private static final LocationGeoip defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<LocationGeoip> PARSER = new AbstractParser() {
            public WebMsgProto.LocationGeoip parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.LocationGeoip(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int PROVIDER_FIELD_NUMBER = 1;
        private Object provider_;
        public static final int CONTINENT_FIELD_NUMBER = 2;
        private Object continent_;
        public static final int COUNTRY_FIELD_NUMBER = 3;
        private Object country_;
        public static final int CITY_FIELD_NUMBER = 4;
        private Object city_;
        public static final int LATITUDE_FIELD_NUMBER = 5;
        private double latitude_;
        public static final int LONGITUDE_FIELD_NUMBER = 6;
        private double longitude_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new LocationGeoip(true);
            defaultInstance.initFields();
        }

        private LocationGeoip(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private LocationGeoip(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LocationGeoip getDefaultInstance() {
            return defaultInstance;
        }

        public LocationGeoip getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LocationGeoip(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.provider_ = input.readBytes();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.continent_ = input.readBytes();
                            break;
                        case 26:
                            this.bitField0_ |= 4;
                            this.country_ = input.readBytes();
                            break;
                        case 34:
                            this.bitField0_ |= 8;
                            this.city_ = input.readBytes();
                            break;
                        case 41:
                            this.bitField0_ |= 16;
                            this.latitude_ = input.readDouble();
                            break;
                        case 49:
                            this.bitField0_ |= 32;
                            this.longitude_ = input.readDouble();
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_LocationGeoip_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_LocationGeoip_fieldAccessorTable.ensureFieldAccessorsInitialized(LocationGeoip.class, Builder.class);
        }

        public Parser<LocationGeoip> getParserForType() {
            return PARSER;
        }

        public boolean hasProvider() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public String getProvider() {
            Object ref = this.provider_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.provider_ = s;
            }
            return s;
        }

        public ByteString getProviderBytes() {
            Object ref = this.provider_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.provider_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasContinent() {
            return (this.bitField0_ & 0x2) == 2;
        }

        public String getContinent() {
            Object ref = this.continent_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.continent_ = s;
            }
            return s;
        }

        public ByteString getContinentBytes() {
            Object ref = this.continent_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.continent_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasCountry() {
            return (this.bitField0_ & 0x4) == 4;
        }

        public String getCountry() {
            Object ref = this.country_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.country_ = s;
            }
            return s;
        }

        public ByteString getCountryBytes() {
            Object ref = this.country_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.country_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasCity() {
            return (this.bitField0_ & 0x8) == 8;
        }

        public String getCity() {
            Object ref = this.city_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.city_ = s;
            }
            return s;
        }

        public ByteString getCityBytes() {
            Object ref = this.city_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.city_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasLatitude() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public double getLatitude() {
            return this.latitude_;
        }

        public boolean hasLongitude() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public double getLongitude() {
            return this.longitude_;
        }

        private void initFields() {
            this.provider_ = "";
            this.continent_ = "";
            this.country_ = "";
            this.city_ = "";
            this.latitude_ = 0.0D;
            this.longitude_ = 0.0D;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasProvider()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasContinent()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCountry()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCity()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLatitude()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLongitude()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getProviderBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getContinentBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getCountryBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(4, getCityBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeDouble(5, this.latitude_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeDouble(6, this.longitude_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeBytesSize(1, getProviderBytes());
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size = size + CodedOutputStream.computeBytesSize(2, getContinentBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size = size + CodedOutputStream.computeBytesSize(3, getCountryBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size = size + CodedOutputStream.computeBytesSize(4, getCityBytes());
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size = size + CodedOutputStream.computeDoubleSize(5, this.latitude_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size = size + CodedOutputStream.computeDoubleSize(6, this.longitude_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LocationGeoip parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LocationGeoip) PARSER.parseFrom(data);
        }

        public static LocationGeoip parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LocationGeoip) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LocationGeoip parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LocationGeoip) PARSER.parseFrom(data);
        }

        public static LocationGeoip parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LocationGeoip) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LocationGeoip parseFrom(InputStream input) throws IOException {
            return (LocationGeoip) PARSER.parseFrom(input);
        }

        public static LocationGeoip parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LocationGeoip) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LocationGeoip parseDelimitedFrom(InputStream input) throws IOException {
            return (LocationGeoip) PARSER.parseDelimitedFrom(input);
        }

        public static LocationGeoip parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LocationGeoip) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LocationGeoip parseFrom(CodedInputStream input) throws IOException {
            return (LocationGeoip) PARSER.parseFrom(input);
        }

        public static LocationGeoip parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LocationGeoip) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LocationGeoip prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.LocationGeoipOrBuilder {
            private int bitField0_;
            private Object provider_ = "";

            private Object continent_ = "";

            private Object country_ = "";

            private Object city_ = "";
            private double latitude_;
            private double longitude_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_LocationGeoip_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_LocationGeoip_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.LocationGeoip.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                WebMsgProto.LocationGeoip.newBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.provider_ = "";
                this.bitField0_ &= -2;
                this.continent_ = "";
                this.bitField0_ &= -3;
                this.country_ = "";
                this.bitField0_ &= -5;
                this.city_ = "";
                this.bitField0_ &= -9;
                this.latitude_ = 0.0D;
                this.bitField0_ &= -17;
                this.longitude_ = 0.0D;
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_LocationGeoip_descriptor;
            }

            public WebMsgProto.LocationGeoip getDefaultInstanceForType() {
                return WebMsgProto.LocationGeoip.getDefaultInstance();
            }

            public WebMsgProto.LocationGeoip build() {
                WebMsgProto.LocationGeoip result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.LocationGeoip buildPartial() {
                WebMsgProto.LocationGeoip result = new WebMsgProto.LocationGeoip(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.provider_ = this.provider_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.continent_ = this.continent_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.country_ = this.country_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.city_ = this.city_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 16;
                }
                result.latitude_ = this.latitude_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 32;
                }
                result.longitude_ = this.longitude_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.LocationGeoip)) {
                    return mergeFrom((WebMsgProto.LocationGeoip) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.LocationGeoip other) {
                if (other == WebMsgProto.LocationGeoip.getDefaultInstance())
                    return this;
                if (other.hasProvider()) {
                    this.bitField0_ |= 1;
                    this.provider_ = other.provider_;
                    onChanged();
                }
                if (other.hasContinent()) {
                    this.bitField0_ |= 2;
                    this.continent_ = other.continent_;
                    onChanged();
                }
                if (other.hasCountry()) {
                    this.bitField0_ |= 4;
                    this.country_ = other.country_;
                    onChanged();
                }
                if (other.hasCity()) {
                    this.bitField0_ |= 8;
                    this.city_ = other.city_;
                    onChanged();
                }
                if (other.hasLatitude()) {
                    setLatitude(other.getLatitude());
                }
                if (other.hasLongitude()) {
                    setLongitude(other.getLongitude());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasProvider()) {
                    return false;
                }
                if (!hasContinent()) {
                    return false;
                }
                if (!hasCountry()) {
                    return false;
                }
                if (!hasCity()) {
                    return false;
                }
                if (!hasLatitude()) {
                    return false;
                }
                if (!hasLongitude()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.LocationGeoip parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.LocationGeoip) WebMsgProto.LocationGeoip.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.LocationGeoip) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasProvider() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public String getProvider() {
                Object ref = this.provider_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.provider_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getProviderBytes() {
                Object ref = this.provider_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.provider_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setProvider(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.provider_ = value;
                onChanged();
                return this;
            }

            public Builder clearProvider() {
                this.bitField0_ &= -2;
                this.provider_ = WebMsgProto.LocationGeoip.getDefaultInstance().getProvider();
                onChanged();
                return this;
            }

            public Builder setProviderBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.provider_ = value;
                onChanged();
                return this;
            }

            public boolean hasContinent() {
                return (this.bitField0_ & 0x2) == 2;
            }

            public String getContinent() {
                Object ref = this.continent_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.continent_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getContinentBytes() {
                Object ref = this.continent_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.continent_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setContinent(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.continent_ = value;
                onChanged();
                return this;
            }

            public Builder clearContinent() {
                this.bitField0_ &= -3;
                this.continent_ = WebMsgProto.LocationGeoip.getDefaultInstance().getContinent();
                onChanged();
                return this;
            }

            public Builder setContinentBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.continent_ = value;
                onChanged();
                return this;
            }

            public boolean hasCountry() {
                return (this.bitField0_ & 0x4) == 4;
            }

            public String getCountry() {
                Object ref = this.country_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.country_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getCountryBytes() {
                Object ref = this.country_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.country_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setCountry(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.country_ = value;
                onChanged();
                return this;
            }

            public Builder clearCountry() {
                this.bitField0_ &= -5;
                this.country_ = WebMsgProto.LocationGeoip.getDefaultInstance().getCountry();
                onChanged();
                return this;
            }

            public Builder setCountryBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.country_ = value;
                onChanged();
                return this;
            }

            public boolean hasCity() {
                return (this.bitField0_ & 0x8) == 8;
            }

            public String getCity() {
                Object ref = this.city_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.city_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getCityBytes() {
                Object ref = this.city_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.city_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setCity(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.city_ = value;
                onChanged();
                return this;
            }

            public Builder clearCity() {
                this.bitField0_ &= -9;
                this.city_ = WebMsgProto.LocationGeoip.getDefaultInstance().getCity();
                onChanged();
                return this;
            }

            public Builder setCityBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.city_ = value;
                onChanged();
                return this;
            }

            public boolean hasLatitude() {
                return (this.bitField0_ & 0x10) == 16;
            }

            public double getLatitude() {
                return this.latitude_;
            }

            public Builder setLatitude(double value) {
                this.bitField0_ |= 16;
                this.latitude_ = value;
                onChanged();
                return this;
            }

            public Builder clearLatitude() {
                this.bitField0_ &= -17;
                this.latitude_ = 0.0D;
                onChanged();
                return this;
            }

            public boolean hasLongitude() {
                return (this.bitField0_ & 0x20) == 32;
            }

            public double getLongitude() {
                return this.longitude_;
            }

            public Builder setLongitude(double value) {
                this.bitField0_ |= 32;
                this.longitude_ = value;
                onChanged();
                return this;
            }

            public Builder clearLongitude() {
                this.bitField0_ &= -33;
                this.longitude_ = 0.0D;
                onChanged();
                return this;
            }
        }
    }

    public static abstract interface LocationGeoipOrBuilder extends MessageOrBuilder {
        public abstract boolean hasProvider();

        public abstract String getProvider();

        public abstract ByteString getProviderBytes();

        public abstract boolean hasContinent();

        public abstract String getContinent();

        public abstract ByteString getContinentBytes();

        public abstract boolean hasCountry();

        public abstract String getCountry();

        public abstract ByteString getCountryBytes();

        public abstract boolean hasCity();

        public abstract String getCity();

        public abstract ByteString getCityBytes();

        public abstract boolean hasLatitude();

        public abstract double getLatitude();

        public abstract boolean hasLongitude();

        public abstract double getLongitude();
    }

    public static abstract interface LocationOrBuilder extends MessageOrBuilder {
        public abstract boolean hasIp();

        public abstract ByteString getIp();

        public abstract boolean hasBrowserLang();

        public abstract String getBrowserLang();

        public abstract ByteString getBrowserLangBytes();

        public abstract boolean hasCountry();

        public abstract String getCountry();

        public abstract ByteString getCountryBytes();

        public abstract boolean hasRegion();

        public abstract String getRegion();

        public abstract ByteString getRegionBytes();

        public abstract boolean hasCity();

        public abstract String getCity();

        public abstract ByteString getCityBytes();

        public abstract boolean hasLatitude();

        public abstract float getLatitude();

        public abstract boolean hasLocationLongitude();

        public abstract float getLocationLongitude();
    }

    public static final class LogActionItem extends GeneratedMessage implements WebMsgProto.LogActionItemOrBuilder {
        private static final LogActionItem defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<LogActionItem> PARSER = new AbstractParser() {
            public WebMsgProto.LogActionItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.LogActionItem(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TS_UPDATED_FIELD_NUMBER = 1;
        private long tsUpdated_;
        public static final int LOGACTION_FIELD_NUMBER = 2;
        private List<WebMsgProto.LogActionRecord> logaction_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new LogActionItem(true);
            defaultInstance.initFields();
        }

        private LogActionItem(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private LogActionItem(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LogActionItem getDefaultInstance() {
            return defaultInstance;
        }

        public LogActionItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LogActionItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.tsUpdated_ = input.readInt64();
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.logaction_ = new ArrayList();
                                mutable_bitField0_ |= 2;
                            }
                            this.logaction_.add((WebMsgProto.LogActionRecord) input.readMessage(WebMsgProto.LogActionRecord.PARSER, extensionRegistry));
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) {
                    this.logaction_ = Collections.unmodifiableList(this.logaction_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_LogActionItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_LogActionItem_fieldAccessorTable.ensureFieldAccessorsInitialized(LogActionItem.class, Builder.class);
        }

        public Parser<LogActionItem> getParserForType() {
            return PARSER;
        }

        public boolean hasTsUpdated() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public long getTsUpdated() {
            return this.tsUpdated_;
        }

        public List<WebMsgProto.LogActionRecord> getLogactionList() {
            return this.logaction_;
        }

        public List<? extends WebMsgProto.LogActionRecordOrBuilder> getLogactionOrBuilderList() {
            return this.logaction_;
        }

        public int getLogactionCount() {
            return this.logaction_.size();
        }

        public WebMsgProto.LogActionRecord getLogaction(int index) {
            return (WebMsgProto.LogActionRecord) this.logaction_.get(index);
        }

        public WebMsgProto.LogActionRecordOrBuilder getLogactionOrBuilder(int index) {
            return (WebMsgProto.LogActionRecordOrBuilder) this.logaction_.get(index);
        }

        private void initFields() {
            this.tsUpdated_ = 0L;
            this.logaction_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasTsUpdated()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getLogactionCount(); i++) {
                if (!getLogaction(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt64(1, this.tsUpdated_);
            }
            for (int i = 0; i < this.logaction_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.logaction_.get(i));
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeInt64Size(1, this.tsUpdated_);
            }
            for (int i = 0; i < this.logaction_.size(); i++) {
                size = size + CodedOutputStream.computeMessageSize(2, (MessageLite) this.logaction_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LogActionItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LogActionItem) PARSER.parseFrom(data);
        }

        public static LogActionItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LogActionItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LogActionItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LogActionItem) PARSER.parseFrom(data);
        }

        public static LogActionItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LogActionItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LogActionItem parseFrom(InputStream input) throws IOException {
            return (LogActionItem) PARSER.parseFrom(input);
        }

        public static LogActionItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LogActionItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LogActionItem parseDelimitedFrom(InputStream input) throws IOException {
            return (LogActionItem) PARSER.parseDelimitedFrom(input);
        }

        public static LogActionItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LogActionItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LogActionItem parseFrom(CodedInputStream input) throws IOException {
            return (LogActionItem) PARSER.parseFrom(input);
        }

        public static LogActionItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LogActionItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LogActionItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.LogActionItemOrBuilder {
            private int bitField0_;
            private long tsUpdated_;
            private List<WebMsgProto.LogActionRecord> logaction_ = Collections.emptyList();
            private RepeatedFieldBuilder<WebMsgProto.LogActionRecord, WebMsgProto.LogActionRecord.Builder, WebMsgProto.LogActionRecordOrBuilder> logactionBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_LogActionItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_LogActionItem_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.LogActionItem.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WebMsgProto.LogActionItem.alwaysUseFieldBuilders)
                    getLogactionFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.tsUpdated_ = 0L;
                this.bitField0_ &= -2;
                if (this.logactionBuilder_ == null) {
                    this.logaction_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.logactionBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_LogActionItem_descriptor;
            }

            public WebMsgProto.LogActionItem getDefaultInstanceForType() {
                return WebMsgProto.LogActionItem.getDefaultInstance();
            }

            public WebMsgProto.LogActionItem build() {
                WebMsgProto.LogActionItem result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.LogActionItem buildPartial() {
                WebMsgProto.LogActionItem result = new WebMsgProto.LogActionItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.tsUpdated_ = this.tsUpdated_;
                if (this.logactionBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.logaction_ = Collections.unmodifiableList(this.logaction_);
                        this.bitField0_ &= -3;
                    }
                    result.logaction_ = this.logaction_;
                } else {
                    result.logaction_ = this.logactionBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.LogActionItem)) {
                    return mergeFrom((WebMsgProto.LogActionItem) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.LogActionItem other) {
                if (other == WebMsgProto.LogActionItem.getDefaultInstance())
                    return this;
                if (other.hasTsUpdated()) {
                    setTsUpdated(other.getTsUpdated());
                }
                if (this.logactionBuilder_ == null) {
                    if (!other.logaction_.isEmpty()) {
                        if (this.logaction_.isEmpty()) {
                            this.logaction_ = other.logaction_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureLogactionIsMutable();
                            this.logaction_.addAll(other.logaction_);
                        }
                        onChanged();
                    }
                } else if (!other.logaction_.isEmpty()) {
                    if (this.logactionBuilder_.isEmpty()) {
                        this.logactionBuilder_.dispose();
                        this.logactionBuilder_ = null;
                        this.logaction_ = other.logaction_;
                        this.bitField0_ &= -3;
                        this.logactionBuilder_ = (WebMsgProto.LogActionItem.alwaysUseFieldBuilders ? getLogactionFieldBuilder() : null);
                    } else {
                        this.logactionBuilder_.addAllMessages(other.logaction_);
                    }
                }

                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasTsUpdated()) {
                    return false;
                }
                for (int i = 0; i < getLogactionCount(); i++) {
                    if (!getLogaction(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.LogActionItem parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.LogActionItem) WebMsgProto.LogActionItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.LogActionItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasTsUpdated() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public long getTsUpdated() {
                return this.tsUpdated_;
            }

            public Builder setTsUpdated(long value) {
                this.bitField0_ |= 1;
                this.tsUpdated_ = value;
                onChanged();
                return this;
            }

            public Builder clearTsUpdated() {
                this.bitField0_ &= -2;
                this.tsUpdated_ = 0L;
                onChanged();
                return this;
            }

            private void ensureLogactionIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.logaction_ = new ArrayList(this.logaction_);
                    this.bitField0_ |= 2;
                }
            }

            public List<WebMsgProto.LogActionRecord> getLogactionList() {
                if (this.logactionBuilder_ == null) {
                    return Collections.unmodifiableList(this.logaction_);
                }
                return this.logactionBuilder_.getMessageList();
            }

            public int getLogactionCount() {
                if (this.logactionBuilder_ == null) {
                    return this.logaction_.size();
                }
                return this.logactionBuilder_.getCount();
            }

            public WebMsgProto.LogActionRecord getLogaction(int index) {
                if (this.logactionBuilder_ == null) {
                    return (WebMsgProto.LogActionRecord) this.logaction_.get(index);
                }
                return (WebMsgProto.LogActionRecord) this.logactionBuilder_.getMessage(index);
            }

            public Builder setLogaction(int index, WebMsgProto.LogActionRecord value) {
                if (this.logactionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLogactionIsMutable();
                    this.logaction_.set(index, value);
                    onChanged();
                } else {
                    this.logactionBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setLogaction(int index, WebMsgProto.LogActionRecord.Builder builderForValue) {
                if (this.logactionBuilder_ == null) {
                    ensureLogactionIsMutable();
                    this.logaction_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.logactionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLogaction(WebMsgProto.LogActionRecord value) {
                if (this.logactionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLogactionIsMutable();
                    this.logaction_.add(value);
                    onChanged();
                } else {
                    this.logactionBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addLogaction(int index, WebMsgProto.LogActionRecord value) {
                if (this.logactionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLogactionIsMutable();
                    this.logaction_.add(index, value);
                    onChanged();
                } else {
                    this.logactionBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addLogaction(WebMsgProto.LogActionRecord.Builder builderForValue) {
                if (this.logactionBuilder_ == null) {
                    ensureLogactionIsMutable();
                    this.logaction_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.logactionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLogaction(int index, WebMsgProto.LogActionRecord.Builder builderForValue) {
                if (this.logactionBuilder_ == null) {
                    ensureLogactionIsMutable();
                    this.logaction_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.logactionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLogaction(Iterable<? extends WebMsgProto.LogActionRecord> values) {
                if (this.logactionBuilder_ == null) {
                    ensureLogactionIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.logaction_);
                    onChanged();
                } else {
                    this.logactionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLogaction() {
                if (this.logactionBuilder_ == null) {
                    this.logaction_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.logactionBuilder_.clear();
                }
                return this;
            }

            public Builder removeLogaction(int index) {
                if (this.logactionBuilder_ == null) {
                    ensureLogactionIsMutable();
                    this.logaction_.remove(index);
                    onChanged();
                } else {
                    this.logactionBuilder_.remove(index);
                }
                return this;
            }

            public WebMsgProto.LogActionRecord.Builder getLogactionBuilder(int index) {
                return (WebMsgProto.LogActionRecord.Builder) getLogactionFieldBuilder().getBuilder(index);
            }

            public WebMsgProto.LogActionRecordOrBuilder getLogactionOrBuilder(int index) {
                if (this.logactionBuilder_ == null)
                    return (WebMsgProto.LogActionRecordOrBuilder) this.logaction_.get(index);
                return (WebMsgProto.LogActionRecordOrBuilder) this.logactionBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends WebMsgProto.LogActionRecordOrBuilder> getLogactionOrBuilderList() {
                if (this.logactionBuilder_ != null) {
                    return this.logactionBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.logaction_);
            }

            public WebMsgProto.LogActionRecord.Builder addLogactionBuilder() {
                return (WebMsgProto.LogActionRecord.Builder) getLogactionFieldBuilder().addBuilder(WebMsgProto.LogActionRecord.getDefaultInstance());
            }

            public WebMsgProto.LogActionRecord.Builder addLogactionBuilder(int index) {
                return (WebMsgProto.LogActionRecord.Builder) getLogactionFieldBuilder().addBuilder(index, WebMsgProto.LogActionRecord.getDefaultInstance());
            }

            public List<WebMsgProto.LogActionRecord.Builder> getLogactionBuilderList() {
                return getLogactionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<WebMsgProto.LogActionRecord, WebMsgProto.LogActionRecord.Builder, WebMsgProto.LogActionRecordOrBuilder> getLogactionFieldBuilder() {
                if (this.logactionBuilder_ == null) {
                    this.logactionBuilder_ = new RepeatedFieldBuilder(this.logaction_, (this.bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
                    this.logaction_ = null;
                }
                return this.logactionBuilder_;
            }
        }
    }

    public static abstract interface LogActionItemOrBuilder extends MessageOrBuilder {
        public abstract boolean hasTsUpdated();

        public abstract long getTsUpdated();

        public abstract List<WebMsgProto.LogActionRecord> getLogactionList();

        public abstract WebMsgProto.LogActionRecord getLogaction(int paramInt);

        public abstract int getLogactionCount();

        public abstract List<? extends WebMsgProto.LogActionRecordOrBuilder> getLogactionOrBuilderList();

        public abstract WebMsgProto.LogActionRecordOrBuilder getLogactionOrBuilder(int paramInt);
    }

    public static final class LogActionRecord extends GeneratedMessage implements WebMsgProto.LogActionRecordOrBuilder {
        private static final LogActionRecord defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<LogActionRecord> PARSER = new AbstractParser() {
            public WebMsgProto.LogActionRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.LogActionRecord(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int IDACTION_FIELD_NUMBER = 1;
        private int idaction_;
        public static final int NAME_FIELD_NUMBER = 2;
        private Object name_;
        public static final int HASH_FIELD_NUMBER = 3;
        private int hash_;
        public static final int TYPE_FIELD_NUMBER = 4;
        private int type_;
        public static final int URL_PREFIX_FIELD_NUMBER = 5;
        private int urlPrefix_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new LogActionRecord(true);
            defaultInstance.initFields();
        }

        private LogActionRecord(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private LogActionRecord(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LogActionRecord getDefaultInstance() {
            return defaultInstance;
        }

        public LogActionRecord getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LogActionRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.idaction_ = input.readInt32();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.name_ = input.readBytes();
                            break;
                        case 24:
                            this.bitField0_ |= 4;
                            this.hash_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 8;
                            this.type_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 16;
                            this.urlPrefix_ = input.readInt32();
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_LogActionRecord_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_LogActionRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(LogActionRecord.class, Builder.class);
        }

        public Parser<LogActionRecord> getParserForType() {
            return PARSER;
        }

        public boolean hasIdaction() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public int getIdaction() {
            return this.idaction_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 0x2) == 2;
        }

        public String getName() {
            Object ref = this.name_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.name_ = s;
            }
            return s;
        }

        public ByteString getNameBytes() {
            Object ref = this.name_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.name_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasHash() {
            return (this.bitField0_ & 0x4) == 4;
        }

        public int getHash() {
            return this.hash_;
        }

        public boolean hasType() {
            return (this.bitField0_ & 0x8) == 8;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasUrlPrefix() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public int getUrlPrefix() {
            return this.urlPrefix_;
        }

        private void initFields() {
            this.idaction_ = 0;
            this.name_ = "";
            this.hash_ = 0;
            this.type_ = 0;
            this.urlPrefix_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasIdaction()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasHash()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasUrlPrefix()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.idaction_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.hash_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.type_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.urlPrefix_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeInt32Size(1, this.idaction_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size = size + CodedOutputStream.computeBytesSize(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size = size + CodedOutputStream.computeInt32Size(3, this.hash_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size = size + CodedOutputStream.computeInt32Size(4, this.type_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size = size + CodedOutputStream.computeInt32Size(5, this.urlPrefix_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LogActionRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LogActionRecord) PARSER.parseFrom(data);
        }

        public static LogActionRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LogActionRecord) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LogActionRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LogActionRecord) PARSER.parseFrom(data);
        }

        public static LogActionRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LogActionRecord) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LogActionRecord parseFrom(InputStream input) throws IOException {
            return (LogActionRecord) PARSER.parseFrom(input);
        }

        public static LogActionRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LogActionRecord) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LogActionRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (LogActionRecord) PARSER.parseDelimitedFrom(input);
        }

        public static LogActionRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LogActionRecord) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LogActionRecord parseFrom(CodedInputStream input) throws IOException {
            return (LogActionRecord) PARSER.parseFrom(input);
        }

        public static LogActionRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LogActionRecord) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LogActionRecord prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.LogActionRecordOrBuilder {
            private int bitField0_;
            private int idaction_;
            private Object name_ = "";
            private int hash_;
            private int type_;
            private int urlPrefix_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_LogActionRecord_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_LogActionRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.LogActionRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                WebMsgProto.LogActionRecord.newBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.idaction_ = 0;
                this.bitField0_ &= -2;
                this.name_ = "";
                this.bitField0_ &= -3;
                this.hash_ = 0;
                this.bitField0_ &= -5;
                this.type_ = 0;
                this.bitField0_ &= -9;
                this.urlPrefix_ = 0;
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_LogActionRecord_descriptor;
            }

            public WebMsgProto.LogActionRecord getDefaultInstanceForType() {
                return WebMsgProto.LogActionRecord.getDefaultInstance();
            }

            public WebMsgProto.LogActionRecord build() {
                WebMsgProto.LogActionRecord result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.LogActionRecord buildPartial() {
                WebMsgProto.LogActionRecord result = new WebMsgProto.LogActionRecord(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.idaction_ = this.idaction_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.hash_ = this.hash_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 16;
                }
                result.urlPrefix_ = this.urlPrefix_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.LogActionRecord)) {
                    return mergeFrom((WebMsgProto.LogActionRecord) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.LogActionRecord other) {
                if (other == WebMsgProto.LogActionRecord.getDefaultInstance())
                    return this;
                if (other.hasIdaction()) {
                    setIdaction(other.getIdaction());
                }
                if (other.hasName()) {
                    this.bitField0_ |= 2;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasHash()) {
                    setHash(other.getHash());
                }
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (other.hasUrlPrefix()) {
                    setUrlPrefix(other.getUrlPrefix());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasIdaction()) {
                    return false;
                }
                if (!hasName()) {
                    return false;
                }
                if (!hasHash()) {
                    return false;
                }
                if (!hasType()) {
                    return false;
                }
                if (!hasUrlPrefix()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.LogActionRecord parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.LogActionRecord) WebMsgProto.LogActionRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.LogActionRecord) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasIdaction() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public int getIdaction() {
                return this.idaction_;
            }

            public Builder setIdaction(int value) {
                this.bitField0_ |= 1;
                this.idaction_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdaction() {
                this.bitField0_ &= -2;
                this.idaction_ = 0;
                onChanged();
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 0x2) == 2;
            }

            public String getName() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.name_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getNameBytes() {
                Object ref = this.name_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.name_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -3;
                this.name_ = WebMsgProto.LogActionRecord.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.name_ = value;
                onChanged();
                return this;
            }

            public boolean hasHash() {
                return (this.bitField0_ & 0x4) == 4;
            }

            public int getHash() {
                return this.hash_;
            }

            public Builder setHash(int value) {
                this.bitField0_ |= 4;
                this.hash_ = value;
                onChanged();
                return this;
            }

            public Builder clearHash() {
                this.bitField0_ &= -5;
                this.hash_ = 0;
                onChanged();
                return this;
            }

            public boolean hasType() {
                return (this.bitField0_ & 0x8) == 8;
            }

            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.bitField0_ |= 8;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= -9;
                this.type_ = 0;
                onChanged();
                return this;
            }

            public boolean hasUrlPrefix() {
                return (this.bitField0_ & 0x10) == 16;
            }

            public int getUrlPrefix() {
                return this.urlPrefix_;
            }

            public Builder setUrlPrefix(int value) {
                this.bitField0_ |= 16;
                this.urlPrefix_ = value;
                onChanged();
                return this;
            }

            public Builder clearUrlPrefix() {
                this.bitField0_ &= -17;
                this.urlPrefix_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static abstract interface LogActionRecordOrBuilder extends MessageOrBuilder {
        public abstract boolean hasIdaction();

        public abstract int getIdaction();

        public abstract boolean hasName();

        public abstract String getName();

        public abstract ByteString getNameBytes();

        public abstract boolean hasHash();

        public abstract int getHash();

        public abstract boolean hasType();

        public abstract int getType();

        public abstract boolean hasUrlPrefix();

        public abstract int getUrlPrefix();
    }

    public static final class LogVisitItem extends GeneratedMessage implements WebMsgProto.LogVisitItemOrBuilder {
        private static final LogVisitItem defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<LogVisitItem> PARSER = new AbstractParser() {
            public WebMsgProto.LogVisitItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.LogVisitItem(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int IDVISIT_FIELD_NUMBER = 1;
        private long idvisit_;
        public static final int IDSITE_FIELD_NUMBER = 2;
        private long idsite_;
        public static final int VISITOR_FIELD_NUMBER = 3;
        private WebMsgProto.Visitor visitor_;
        public static final int REFERER_FIELD_NUMBER = 4;
        private WebMsgProto.Referer referer_;
        public static final int CONFIG_FIELD_NUMBER = 5;
        private WebMsgProto.Config config_;
        public static final int LOCATION_FIELD_NUMBER = 6;
        private WebMsgProto.Location location_;
        public static final int KVPAIR_FIELD_NUMBER = 7;
        private List<WebMsgProto.KVPair> kvpair_;
        public static final int GEOIP_FIELD_NUMBER = 8;
        private WebMsgProto.LocationGeoip geoip_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new LogVisitItem(true);
            defaultInstance.initFields();
        }

        private LogVisitItem(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private LogVisitItem(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static LogVisitItem getDefaultInstance() {
            return defaultInstance;
        }

        public LogVisitItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LogVisitItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.idvisit_ = input.readInt64();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.idsite_ = input.readInt64();
                            break;
                        case 26:
                            WebMsgProto.Visitor.Builder subBuilder = null;
                            if ((this.bitField0_ & 0x4) == 4) {
                                subBuilder = this.visitor_.toBuilder();
                            }
                            this.visitor_ = ((WebMsgProto.Visitor) input.readMessage(WebMsgProto.Visitor.PARSER, extensionRegistry));
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(this.visitor_);
                                this.visitor_ = subBuilder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            break;
                        case 34:
                            WebMsgProto.Referer.Builder subBuilder1 = null;
                            if ((this.bitField0_ & 0x8) == 8) {
                                subBuilder1 = this.referer_.toBuilder();
                            }
                            this.referer_ = ((WebMsgProto.Referer) input.readMessage(WebMsgProto.Referer.PARSER, extensionRegistry));
                            if (subBuilder1 != null) {
                                subBuilder1.mergeFrom(this.referer_);
                                this.referer_ = subBuilder1.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            break;
                        case 42:
                            WebMsgProto.Config.Builder subBuilder11 = null;
                            if ((this.bitField0_ & 0x10) == 16) {
                                subBuilder11 = this.config_.toBuilder();
                            }
                            this.config_ = ((WebMsgProto.Config) input.readMessage(WebMsgProto.Config.PARSER, extensionRegistry));
                            if (subBuilder11 != null) {
                                subBuilder11.mergeFrom(this.config_);
                                this.config_ = subBuilder11.buildPartial();
                            }
                            this.bitField0_ |= 16;
                            break;
                        case 50:
                            WebMsgProto.Location.Builder subBuilder111 = null;
                            if ((this.bitField0_ & 0x20) == 32) {
                                subBuilder111 = this.location_.toBuilder();
                            }
                            this.location_ = ((WebMsgProto.Location) input.readMessage(WebMsgProto.Location.PARSER, extensionRegistry));
                            if (subBuilder111 != null) {
                                subBuilder111.mergeFrom(this.location_);
                                this.location_ = subBuilder111.buildPartial();
                            }
                            this.bitField0_ |= 32;
                            break;
                        case 58:
                            if ((mutable_bitField0_ & 0x40) != 64) {
                                this.kvpair_ = new ArrayList();
                                mutable_bitField0_ |= 64;
                            }
                            this.kvpair_.add((WebMsgProto.KVPair) input.readMessage(WebMsgProto.KVPair.PARSER, extensionRegistry));
                            break;
                        case 66:
                            WebMsgProto.LocationGeoip.Builder subBuilder1111 = null;
                            if ((this.bitField0_ & 0x40) == 64) {
                                subBuilder1111 = this.geoip_.toBuilder();
                            }
                            this.geoip_ = ((WebMsgProto.LocationGeoip) input.readMessage(WebMsgProto.LocationGeoip.PARSER, extensionRegistry));
                            if (subBuilder1111 != null) {
                                subBuilder1111.mergeFrom(this.geoip_);
                                this.geoip_ = subBuilder1111.buildPartial();
                            }
                            this.bitField0_ |= 64;
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x40) == 64) {
                    this.kvpair_ = Collections.unmodifiableList(this.kvpair_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_LogVisitItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_LogVisitItem_fieldAccessorTable.ensureFieldAccessorsInitialized(LogVisitItem.class, Builder.class);
        }

        public Parser<LogVisitItem> getParserForType() {
            return PARSER;
        }

        public boolean hasIdvisit() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public long getIdvisit() {
            return this.idvisit_;
        }

        public boolean hasIdsite() {
            return (this.bitField0_ & 0x2) == 2;
        }

        public long getIdsite() {
            return this.idsite_;
        }

        public boolean hasVisitor() {
            return (this.bitField0_ & 0x4) == 4;
        }

        public WebMsgProto.Visitor getVisitor() {
            return this.visitor_;
        }

        public WebMsgProto.VisitorOrBuilder getVisitorOrBuilder() {
            return this.visitor_;
        }

        public boolean hasReferer() {
            return (this.bitField0_ & 0x8) == 8;
        }

        public WebMsgProto.Referer getReferer() {
            return this.referer_;
        }

        public WebMsgProto.RefererOrBuilder getRefererOrBuilder() {
            return this.referer_;
        }

        public boolean hasConfig() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public WebMsgProto.Config getConfig() {
            return this.config_;
        }

        public WebMsgProto.ConfigOrBuilder getConfigOrBuilder() {
            return this.config_;
        }

        public boolean hasLocation() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public WebMsgProto.Location getLocation() {
            return this.location_;
        }

        public WebMsgProto.LocationOrBuilder getLocationOrBuilder() {
            return this.location_;
        }

        public List<WebMsgProto.KVPair> getKvpairList() {
            return this.kvpair_;
        }

        public List<? extends WebMsgProto.KVPairOrBuilder> getKvpairOrBuilderList() {
            return this.kvpair_;
        }

        public int getKvpairCount() {
            return this.kvpair_.size();
        }

        public WebMsgProto.KVPair getKvpair(int index) {
            return (WebMsgProto.KVPair) this.kvpair_.get(index);
        }

        public WebMsgProto.KVPairOrBuilder getKvpairOrBuilder(int index) {
            return (WebMsgProto.KVPairOrBuilder) this.kvpair_.get(index);
        }

        public boolean hasGeoip() {
            return (this.bitField0_ & 0x40) == 64;
        }

        public WebMsgProto.LocationGeoip getGeoip() {
            return this.geoip_;
        }

        public WebMsgProto.LocationGeoipOrBuilder getGeoipOrBuilder() {
            return this.geoip_;
        }

        private void initFields() {
            this.idvisit_ = 0L;
            this.idsite_ = 0L;
            this.visitor_ = WebMsgProto.Visitor.getDefaultInstance();
            this.referer_ = WebMsgProto.Referer.getDefaultInstance();
            this.config_ = WebMsgProto.Config.getDefaultInstance();
            this.location_ = WebMsgProto.Location.getDefaultInstance();
            this.kvpair_ = Collections.emptyList();
            this.geoip_ = WebMsgProto.LocationGeoip.getDefaultInstance();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasIdvisit()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasIdsite()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasVisitor()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasReferer()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasConfig()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLocation()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasGeoip()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getVisitor().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getReferer().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getConfig().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!getLocation().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getKvpairCount(); i++) {
                if (!getKvpair(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!getGeoip().isInitialized()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt64(1, this.idvisit_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt64(2, this.idsite_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeMessage(3, this.visitor_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeMessage(4, this.referer_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeMessage(5, this.config_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeMessage(6, this.location_);
            }
            for (int i = 0; i < this.kvpair_.size(); i++) {
                output.writeMessage(7, (MessageLite) this.kvpair_.get(i));
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeMessage(8, this.geoip_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeInt64Size(1, this.idvisit_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size = size + CodedOutputStream.computeInt64Size(2, this.idsite_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size = size + CodedOutputStream.computeMessageSize(3, this.visitor_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size = size + CodedOutputStream.computeMessageSize(4, this.referer_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size = size + CodedOutputStream.computeMessageSize(5, this.config_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size = size + CodedOutputStream.computeMessageSize(6, this.location_);
            }
            for (int i = 0; i < this.kvpair_.size(); i++) {
                size = size + CodedOutputStream.computeMessageSize(7, (MessageLite) this.kvpair_.get(i));
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size = size + CodedOutputStream.computeMessageSize(8, this.geoip_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LogVisitItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LogVisitItem) PARSER.parseFrom(data);
        }

        public static LogVisitItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LogVisitItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LogVisitItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LogVisitItem) PARSER.parseFrom(data);
        }

        public static LogVisitItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LogVisitItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static LogVisitItem parseFrom(InputStream input) throws IOException {
            return (LogVisitItem) PARSER.parseFrom(input);
        }

        public static LogVisitItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LogVisitItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static LogVisitItem parseDelimitedFrom(InputStream input) throws IOException {
            return (LogVisitItem) PARSER.parseDelimitedFrom(input);
        }

        public static LogVisitItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LogVisitItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static LogVisitItem parseFrom(CodedInputStream input) throws IOException {
            return (LogVisitItem) PARSER.parseFrom(input);
        }

        public static LogVisitItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LogVisitItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(LogVisitItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.LogVisitItemOrBuilder {
            private int bitField0_;
            private long idvisit_;
            private long idsite_;
            private WebMsgProto.Visitor visitor_ = WebMsgProto.Visitor.getDefaultInstance();
            private SingleFieldBuilder<WebMsgProto.Visitor, WebMsgProto.Visitor.Builder, WebMsgProto.VisitorOrBuilder> visitorBuilder_;
            private WebMsgProto.Referer referer_ = WebMsgProto.Referer.getDefaultInstance();
            private SingleFieldBuilder<WebMsgProto.Referer, WebMsgProto.Referer.Builder, WebMsgProto.RefererOrBuilder> refererBuilder_;
            private WebMsgProto.Config config_ = WebMsgProto.Config.getDefaultInstance();
            private SingleFieldBuilder<WebMsgProto.Config, WebMsgProto.Config.Builder, WebMsgProto.ConfigOrBuilder> configBuilder_;
            private WebMsgProto.Location location_ = WebMsgProto.Location.getDefaultInstance();
            private SingleFieldBuilder<WebMsgProto.Location, WebMsgProto.Location.Builder, WebMsgProto.LocationOrBuilder> locationBuilder_;
            private List<WebMsgProto.KVPair> kvpair_ = Collections.emptyList();
            private RepeatedFieldBuilder<WebMsgProto.KVPair, WebMsgProto.KVPair.Builder, WebMsgProto.KVPairOrBuilder> kvpairBuilder_;
            private WebMsgProto.LocationGeoip geoip_ = WebMsgProto.LocationGeoip.getDefaultInstance();
            private SingleFieldBuilder<WebMsgProto.LocationGeoip, WebMsgProto.LocationGeoip.Builder, WebMsgProto.LocationGeoipOrBuilder> geoipBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_LogVisitItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_LogVisitItem_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.LogVisitItem.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WebMsgProto.LogVisitItem.alwaysUseFieldBuilders) {
                    getVisitorFieldBuilder();
                    getRefererFieldBuilder();
                    getConfigFieldBuilder();
                    getLocationFieldBuilder();
                    getKvpairFieldBuilder();
                    getGeoipFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.idvisit_ = 0L;
                this.bitField0_ &= -2;
                this.idsite_ = 0L;
                this.bitField0_ &= -3;
                if (this.visitorBuilder_ == null)
                    this.visitor_ = WebMsgProto.Visitor.getDefaultInstance();
                else {
                    this.visitorBuilder_.clear();
                }
                this.bitField0_ &= -5;
                if (this.refererBuilder_ == null)
                    this.referer_ = WebMsgProto.Referer.getDefaultInstance();
                else {
                    this.refererBuilder_.clear();
                }
                this.bitField0_ &= -9;
                if (this.configBuilder_ == null)
                    this.config_ = WebMsgProto.Config.getDefaultInstance();
                else {
                    this.configBuilder_.clear();
                }
                this.bitField0_ &= -17;
                if (this.locationBuilder_ == null)
                    this.location_ = WebMsgProto.Location.getDefaultInstance();
                else {
                    this.locationBuilder_.clear();
                }
                this.bitField0_ &= -33;
                if (this.kvpairBuilder_ == null) {
                    this.kvpair_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                } else {
                    this.kvpairBuilder_.clear();
                }
                if (this.geoipBuilder_ == null)
                    this.geoip_ = WebMsgProto.LocationGeoip.getDefaultInstance();
                else {
                    this.geoipBuilder_.clear();
                }
                this.bitField0_ &= -129;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_LogVisitItem_descriptor;
            }

            public WebMsgProto.LogVisitItem getDefaultInstanceForType() {
                return WebMsgProto.LogVisitItem.getDefaultInstance();
            }

            public WebMsgProto.LogVisitItem build() {
                WebMsgProto.LogVisitItem result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.LogVisitItem buildPartial() {
                WebMsgProto.LogVisitItem result = new WebMsgProto.LogVisitItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.idvisit_ = this.idvisit_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.idsite_ = this.idsite_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 4;
                }
                if (this.visitorBuilder_ == null)
                    result.visitor_ = this.visitor_;
                else {
                    result.visitor_ = ((WebMsgProto.Visitor) this.visitorBuilder_.build());
                }
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 8;
                }
                if (this.refererBuilder_ == null)
                    result.referer_ = this.referer_;
                else {
                    result.referer_ = ((WebMsgProto.Referer) this.refererBuilder_.build());
                }
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 16;
                }
                if (this.configBuilder_ == null)
                    result.config_ = this.config_;
                else {
                    result.config_ = ((WebMsgProto.Config) this.configBuilder_.build());
                }
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 32;
                }
                if (this.locationBuilder_ == null)
                    result.location_ = this.location_;
                else {
                    result.location_ = ((WebMsgProto.Location) this.locationBuilder_.build());
                }
                if (this.kvpairBuilder_ == null) {
                    if ((this.bitField0_ & 0x40) == 64) {
                        this.kvpair_ = Collections.unmodifiableList(this.kvpair_);
                        this.bitField0_ &= -65;
                    }
                    result.kvpair_ = this.kvpair_;
                } else {
                    result.kvpair_ = this.kvpairBuilder_.build();
                }
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 64;
                }
                if (this.geoipBuilder_ == null)
                    result.geoip_ = this.geoip_;
                else {
                    result.geoip_ = ((WebMsgProto.LocationGeoip) this.geoipBuilder_.build());
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.LogVisitItem)) {
                    return mergeFrom((WebMsgProto.LogVisitItem) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.LogVisitItem other) {
                if (other == WebMsgProto.LogVisitItem.getDefaultInstance())
                    return this;
                if (other.hasIdvisit()) {
                    setIdvisit(other.getIdvisit());
                }
                if (other.hasIdsite()) {
                    setIdsite(other.getIdsite());
                }
                if (other.hasVisitor()) {
                    mergeVisitor(other.getVisitor());
                }
                if (other.hasReferer()) {
                    mergeReferer(other.getReferer());
                }
                if (other.hasConfig()) {
                    mergeConfig(other.getConfig());
                }
                if (other.hasLocation()) {
                    mergeLocation(other.getLocation());
                }
                if (this.kvpairBuilder_ == null) {
                    if (!other.kvpair_.isEmpty()) {
                        if (this.kvpair_.isEmpty()) {
                            this.kvpair_ = other.kvpair_;
                            this.bitField0_ &= -65;
                        } else {
                            ensureKvpairIsMutable();
                            this.kvpair_.addAll(other.kvpair_);
                        }
                        onChanged();
                    }
                } else if (!other.kvpair_.isEmpty()) {
                    if (this.kvpairBuilder_.isEmpty()) {
                        this.kvpairBuilder_.dispose();
                        this.kvpairBuilder_ = null;
                        this.kvpair_ = other.kvpair_;
                        this.bitField0_ &= -65;
                        this.kvpairBuilder_ = (WebMsgProto.LogVisitItem.alwaysUseFieldBuilders ? getKvpairFieldBuilder() : null);
                    } else {
                        this.kvpairBuilder_.addAllMessages(other.kvpair_);
                    }
                }

                if (other.hasGeoip()) {
                    mergeGeoip(other.getGeoip());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasIdvisit()) {
                    return false;
                }
                if (!hasIdsite()) {
                    return false;
                }
                if (!hasVisitor()) {
                    return false;
                }
                if (!hasReferer()) {
                    return false;
                }
                if (!hasConfig()) {
                    return false;
                }
                if (!hasLocation()) {
                    return false;
                }
                if (!hasGeoip()) {
                    return false;
                }
                if (!getVisitor().isInitialized()) {
                    return false;
                }
                if (!getReferer().isInitialized()) {
                    return false;
                }
                if (!getConfig().isInitialized()) {
                    return false;
                }
                if (!getLocation().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < getKvpairCount(); i++) {
                    if (!getKvpair(i).isInitialized()) {
                        return false;
                    }
                }
                if (!getGeoip().isInitialized()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.LogVisitItem parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.LogVisitItem) WebMsgProto.LogVisitItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.LogVisitItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasIdvisit() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public long getIdvisit() {
                return this.idvisit_;
            }

            public Builder setIdvisit(long value) {
                this.bitField0_ |= 1;
                this.idvisit_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdvisit() {
                this.bitField0_ &= -2;
                this.idvisit_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasIdsite() {
                return (this.bitField0_ & 0x2) == 2;
            }

            public long getIdsite() {
                return this.idsite_;
            }

            public Builder setIdsite(long value) {
                this.bitField0_ |= 2;
                this.idsite_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdsite() {
                this.bitField0_ &= -3;
                this.idsite_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasVisitor() {
                return (this.bitField0_ & 0x4) == 4;
            }

            public WebMsgProto.Visitor getVisitor() {
                if (this.visitorBuilder_ == null) {
                    return this.visitor_;
                }
                return (WebMsgProto.Visitor) this.visitorBuilder_.getMessage();
            }

            public Builder setVisitor(WebMsgProto.Visitor value) {
                if (this.visitorBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.visitor_ = value;
                    onChanged();
                } else {
                    this.visitorBuilder_.setMessage(value);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setVisitor(WebMsgProto.Visitor.Builder builderForValue) {
                if (this.visitorBuilder_ == null) {
                    this.visitor_ = builderForValue.build();
                    onChanged();
                } else {
                    this.visitorBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeVisitor(WebMsgProto.Visitor value) {
                if (this.visitorBuilder_ == null) {
                    if (((this.bitField0_ & 0x4) == 4) && (this.visitor_ != WebMsgProto.Visitor.getDefaultInstance()))
                        this.visitor_ = WebMsgProto.Visitor.newBuilder(this.visitor_).mergeFrom(value).buildPartial();
                    else {
                        this.visitor_ = value;
                    }
                    onChanged();
                } else {
                    this.visitorBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearVisitor() {
                if (this.visitorBuilder_ == null) {
                    this.visitor_ = WebMsgProto.Visitor.getDefaultInstance();
                    onChanged();
                } else {
                    this.visitorBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public WebMsgProto.Visitor.Builder getVisitorBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return (WebMsgProto.Visitor.Builder) getVisitorFieldBuilder().getBuilder();
            }

            public WebMsgProto.VisitorOrBuilder getVisitorOrBuilder() {
                if (this.visitorBuilder_ != null) {
                    return (WebMsgProto.VisitorOrBuilder) this.visitorBuilder_.getMessageOrBuilder();
                }
                return this.visitor_;
            }

            private SingleFieldBuilder<WebMsgProto.Visitor, WebMsgProto.Visitor.Builder, WebMsgProto.VisitorOrBuilder> getVisitorFieldBuilder() {
                if (this.visitorBuilder_ == null) {
                    this.visitorBuilder_ = new SingleFieldBuilder(this.visitor_, getParentForChildren(), isClean());
                    this.visitor_ = null;
                }
                return this.visitorBuilder_;
            }

            public boolean hasReferer() {
                return (this.bitField0_ & 0x8) == 8;
            }

            public WebMsgProto.Referer getReferer() {
                if (this.refererBuilder_ == null) {
                    return this.referer_;
                }
                return (WebMsgProto.Referer) this.refererBuilder_.getMessage();
            }

            public Builder setReferer(WebMsgProto.Referer value) {
                if (this.refererBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.referer_ = value;
                    onChanged();
                } else {
                    this.refererBuilder_.setMessage(value);
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setReferer(WebMsgProto.Referer.Builder builderForValue) {
                if (this.refererBuilder_ == null) {
                    this.referer_ = builderForValue.build();
                    onChanged();
                } else {
                    this.refererBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeReferer(WebMsgProto.Referer value) {
                if (this.refererBuilder_ == null) {
                    if (((this.bitField0_ & 0x8) == 8) && (this.referer_ != WebMsgProto.Referer.getDefaultInstance()))
                        this.referer_ = WebMsgProto.Referer.newBuilder(this.referer_).mergeFrom(value).buildPartial();
                    else {
                        this.referer_ = value;
                    }
                    onChanged();
                } else {
                    this.refererBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearReferer() {
                if (this.refererBuilder_ == null) {
                    this.referer_ = WebMsgProto.Referer.getDefaultInstance();
                    onChanged();
                } else {
                    this.refererBuilder_.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            public WebMsgProto.Referer.Builder getRefererBuilder() {
                this.bitField0_ |= 8;
                onChanged();
                return (WebMsgProto.Referer.Builder) getRefererFieldBuilder().getBuilder();
            }

            public WebMsgProto.RefererOrBuilder getRefererOrBuilder() {
                if (this.refererBuilder_ != null) {
                    return (WebMsgProto.RefererOrBuilder) this.refererBuilder_.getMessageOrBuilder();
                }
                return this.referer_;
            }

            private SingleFieldBuilder<WebMsgProto.Referer, WebMsgProto.Referer.Builder, WebMsgProto.RefererOrBuilder> getRefererFieldBuilder() {
                if (this.refererBuilder_ == null) {
                    this.refererBuilder_ = new SingleFieldBuilder(this.referer_, getParentForChildren(), isClean());
                    this.referer_ = null;
                }
                return this.refererBuilder_;
            }

            public boolean hasConfig() {
                return (this.bitField0_ & 0x10) == 16;
            }

            public WebMsgProto.Config getConfig() {
                if (this.configBuilder_ == null) {
                    return this.config_;
                }
                return (WebMsgProto.Config) this.configBuilder_.getMessage();
            }

            public Builder setConfig(WebMsgProto.Config value) {
                if (this.configBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.config_ = value;
                    onChanged();
                } else {
                    this.configBuilder_.setMessage(value);
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setConfig(WebMsgProto.Config.Builder builderForValue) {
                if (this.configBuilder_ == null) {
                    this.config_ = builderForValue.build();
                    onChanged();
                } else {
                    this.configBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder mergeConfig(WebMsgProto.Config value) {
                if (this.configBuilder_ == null) {
                    if (((this.bitField0_ & 0x10) == 16) && (this.config_ != WebMsgProto.Config.getDefaultInstance()))
                        this.config_ = WebMsgProto.Config.newBuilder(this.config_).mergeFrom(value).buildPartial();
                    else {
                        this.config_ = value;
                    }
                    onChanged();
                } else {
                    this.configBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 16;
                return this;
            }

            public Builder clearConfig() {
                if (this.configBuilder_ == null) {
                    this.config_ = WebMsgProto.Config.getDefaultInstance();
                    onChanged();
                } else {
                    this.configBuilder_.clear();
                }
                this.bitField0_ &= -17;
                return this;
            }

            public WebMsgProto.Config.Builder getConfigBuilder() {
                this.bitField0_ |= 16;
                onChanged();
                return (WebMsgProto.Config.Builder) getConfigFieldBuilder().getBuilder();
            }

            public WebMsgProto.ConfigOrBuilder getConfigOrBuilder() {
                if (this.configBuilder_ != null) {
                    return (WebMsgProto.ConfigOrBuilder) this.configBuilder_.getMessageOrBuilder();
                }
                return this.config_;
            }

            private SingleFieldBuilder<WebMsgProto.Config, WebMsgProto.Config.Builder, WebMsgProto.ConfigOrBuilder> getConfigFieldBuilder() {
                if (this.configBuilder_ == null) {
                    this.configBuilder_ = new SingleFieldBuilder(this.config_, getParentForChildren(), isClean());
                    this.config_ = null;
                }
                return this.configBuilder_;
            }

            public boolean hasLocation() {
                return (this.bitField0_ & 0x20) == 32;
            }

            public WebMsgProto.Location getLocation() {
                if (this.locationBuilder_ == null) {
                    return this.location_;
                }
                return (WebMsgProto.Location) this.locationBuilder_.getMessage();
            }

            public Builder setLocation(WebMsgProto.Location value) {
                if (this.locationBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.location_ = value;
                    onChanged();
                } else {
                    this.locationBuilder_.setMessage(value);
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder setLocation(WebMsgProto.Location.Builder builderForValue) {
                if (this.locationBuilder_ == null) {
                    this.location_ = builderForValue.build();
                    onChanged();
                } else {
                    this.locationBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder mergeLocation(WebMsgProto.Location value) {
                if (this.locationBuilder_ == null) {
                    if (((this.bitField0_ & 0x20) == 32) && (this.location_ != WebMsgProto.Location.getDefaultInstance()))
                        this.location_ = WebMsgProto.Location.newBuilder(this.location_).mergeFrom(value).buildPartial();
                    else {
                        this.location_ = value;
                    }
                    onChanged();
                } else {
                    this.locationBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 32;
                return this;
            }

            public Builder clearLocation() {
                if (this.locationBuilder_ == null) {
                    this.location_ = WebMsgProto.Location.getDefaultInstance();
                    onChanged();
                } else {
                    this.locationBuilder_.clear();
                }
                this.bitField0_ &= -33;
                return this;
            }

            public WebMsgProto.Location.Builder getLocationBuilder() {
                this.bitField0_ |= 32;
                onChanged();
                return (WebMsgProto.Location.Builder) getLocationFieldBuilder().getBuilder();
            }

            public WebMsgProto.LocationOrBuilder getLocationOrBuilder() {
                if (this.locationBuilder_ != null) {
                    return (WebMsgProto.LocationOrBuilder) this.locationBuilder_.getMessageOrBuilder();
                }
                return this.location_;
            }

            private SingleFieldBuilder<WebMsgProto.Location, WebMsgProto.Location.Builder, WebMsgProto.LocationOrBuilder> getLocationFieldBuilder() {
                if (this.locationBuilder_ == null) {
                    this.locationBuilder_ = new SingleFieldBuilder(this.location_, getParentForChildren(), isClean());
                    this.location_ = null;
                }
                return this.locationBuilder_;
            }

            private void ensureKvpairIsMutable() {
                if ((this.bitField0_ & 0x40) != 64) {
                    this.kvpair_ = new ArrayList(this.kvpair_);
                    this.bitField0_ |= 64;
                }
            }

            public List<WebMsgProto.KVPair> getKvpairList() {
                if (this.kvpairBuilder_ == null) {
                    return Collections.unmodifiableList(this.kvpair_);
                }
                return this.kvpairBuilder_.getMessageList();
            }

            public int getKvpairCount() {
                if (this.kvpairBuilder_ == null) {
                    return this.kvpair_.size();
                }
                return this.kvpairBuilder_.getCount();
            }

            public WebMsgProto.KVPair getKvpair(int index) {
                if (this.kvpairBuilder_ == null) {
                    return (WebMsgProto.KVPair) this.kvpair_.get(index);
                }
                return (WebMsgProto.KVPair) this.kvpairBuilder_.getMessage(index);
            }

            public Builder setKvpair(int index, WebMsgProto.KVPair value) {
                if (this.kvpairBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureKvpairIsMutable();
                    this.kvpair_.set(index, value);
                    onChanged();
                } else {
                    this.kvpairBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setKvpair(int index, WebMsgProto.KVPair.Builder builderForValue) {
                if (this.kvpairBuilder_ == null) {
                    ensureKvpairIsMutable();
                    this.kvpair_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.kvpairBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addKvpair(WebMsgProto.KVPair value) {
                if (this.kvpairBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureKvpairIsMutable();
                    this.kvpair_.add(value);
                    onChanged();
                } else {
                    this.kvpairBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addKvpair(int index, WebMsgProto.KVPair value) {
                if (this.kvpairBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureKvpairIsMutable();
                    this.kvpair_.add(index, value);
                    onChanged();
                } else {
                    this.kvpairBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addKvpair(WebMsgProto.KVPair.Builder builderForValue) {
                if (this.kvpairBuilder_ == null) {
                    ensureKvpairIsMutable();
                    this.kvpair_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.kvpairBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addKvpair(int index, WebMsgProto.KVPair.Builder builderForValue) {
                if (this.kvpairBuilder_ == null) {
                    ensureKvpairIsMutable();
                    this.kvpair_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.kvpairBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllKvpair(Iterable<? extends WebMsgProto.KVPair> values) {
                if (this.kvpairBuilder_ == null) {
                    ensureKvpairIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.kvpair_);
                    onChanged();
                } else {
                    this.kvpairBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearKvpair() {
                if (this.kvpairBuilder_ == null) {
                    this.kvpair_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                    onChanged();
                } else {
                    this.kvpairBuilder_.clear();
                }
                return this;
            }

            public Builder removeKvpair(int index) {
                if (this.kvpairBuilder_ == null) {
                    ensureKvpairIsMutable();
                    this.kvpair_.remove(index);
                    onChanged();
                } else {
                    this.kvpairBuilder_.remove(index);
                }
                return this;
            }

            public WebMsgProto.KVPair.Builder getKvpairBuilder(int index) {
                return (WebMsgProto.KVPair.Builder) getKvpairFieldBuilder().getBuilder(index);
            }

            public WebMsgProto.KVPairOrBuilder getKvpairOrBuilder(int index) {
                if (this.kvpairBuilder_ == null)
                    return (WebMsgProto.KVPairOrBuilder) this.kvpair_.get(index);
                return (WebMsgProto.KVPairOrBuilder) this.kvpairBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends WebMsgProto.KVPairOrBuilder> getKvpairOrBuilderList() {
                if (this.kvpairBuilder_ != null) {
                    return this.kvpairBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.kvpair_);
            }

            public WebMsgProto.KVPair.Builder addKvpairBuilder() {
                return (WebMsgProto.KVPair.Builder) getKvpairFieldBuilder().addBuilder(WebMsgProto.KVPair.getDefaultInstance());
            }

            public WebMsgProto.KVPair.Builder addKvpairBuilder(int index) {
                return (WebMsgProto.KVPair.Builder) getKvpairFieldBuilder().addBuilder(index, WebMsgProto.KVPair.getDefaultInstance());
            }

            public List<WebMsgProto.KVPair.Builder> getKvpairBuilderList() {
                return getKvpairFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<WebMsgProto.KVPair, WebMsgProto.KVPair.Builder, WebMsgProto.KVPairOrBuilder> getKvpairFieldBuilder() {
                if (this.kvpairBuilder_ == null) {
                    this.kvpairBuilder_ = new RepeatedFieldBuilder(this.kvpair_, (this.bitField0_ & 0x40) == 64, getParentForChildren(), isClean());
                    this.kvpair_ = null;
                }
                return this.kvpairBuilder_;
            }

            public boolean hasGeoip() {
                return (this.bitField0_ & 0x80) == 128;
            }

            public WebMsgProto.LocationGeoip getGeoip() {
                if (this.geoipBuilder_ == null) {
                    return this.geoip_;
                }
                return (WebMsgProto.LocationGeoip) this.geoipBuilder_.getMessage();
            }

            public Builder setGeoip(WebMsgProto.LocationGeoip value) {
                if (this.geoipBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.geoip_ = value;
                    onChanged();
                } else {
                    this.geoipBuilder_.setMessage(value);
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder setGeoip(WebMsgProto.LocationGeoip.Builder builderForValue) {
                if (this.geoipBuilder_ == null) {
                    this.geoip_ = builderForValue.build();
                    onChanged();
                } else {
                    this.geoipBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder mergeGeoip(WebMsgProto.LocationGeoip value) {
                if (this.geoipBuilder_ == null) {
                    if (((this.bitField0_ & 0x80) == 128) && (this.geoip_ != WebMsgProto.LocationGeoip.getDefaultInstance()))
                        this.geoip_ = WebMsgProto.LocationGeoip.newBuilder(this.geoip_).mergeFrom(value).buildPartial();
                    else {
                        this.geoip_ = value;
                    }
                    onChanged();
                } else {
                    this.geoipBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder clearGeoip() {
                if (this.geoipBuilder_ == null) {
                    this.geoip_ = WebMsgProto.LocationGeoip.getDefaultInstance();
                    onChanged();
                } else {
                    this.geoipBuilder_.clear();
                }
                this.bitField0_ &= -129;
                return this;
            }

            public WebMsgProto.LocationGeoip.Builder getGeoipBuilder() {
                this.bitField0_ |= 128;
                onChanged();
                return (WebMsgProto.LocationGeoip.Builder) getGeoipFieldBuilder().getBuilder();
            }

            public WebMsgProto.LocationGeoipOrBuilder getGeoipOrBuilder() {
                if (this.geoipBuilder_ != null) {
                    return (WebMsgProto.LocationGeoipOrBuilder) this.geoipBuilder_.getMessageOrBuilder();
                }
                return this.geoip_;
            }

            private SingleFieldBuilder<WebMsgProto.LocationGeoip, WebMsgProto.LocationGeoip.Builder, WebMsgProto.LocationGeoipOrBuilder> getGeoipFieldBuilder() {
                if (this.geoipBuilder_ == null) {
                    this.geoipBuilder_ = new SingleFieldBuilder(this.geoip_, getParentForChildren(), isClean());
                    this.geoip_ = null;
                }
                return this.geoipBuilder_;
            }
        }
    }

    public static abstract interface LogVisitItemOrBuilder extends MessageOrBuilder {
        public abstract boolean hasIdvisit();

        public abstract long getIdvisit();

        public abstract boolean hasIdsite();

        public abstract long getIdsite();

        public abstract boolean hasVisitor();

        public abstract WebMsgProto.Visitor getVisitor();

        public abstract WebMsgProto.VisitorOrBuilder getVisitorOrBuilder();

        public abstract boolean hasReferer();

        public abstract WebMsgProto.Referer getReferer();

        public abstract WebMsgProto.RefererOrBuilder getRefererOrBuilder();

        public abstract boolean hasConfig();

        public abstract WebMsgProto.Config getConfig();

        public abstract WebMsgProto.ConfigOrBuilder getConfigOrBuilder();

        public abstract boolean hasLocation();

        public abstract WebMsgProto.Location getLocation();

        public abstract WebMsgProto.LocationOrBuilder getLocationOrBuilder();

        public abstract List<WebMsgProto.KVPair> getKvpairList();

        public abstract WebMsgProto.KVPair getKvpair(int paramInt);

        public abstract int getKvpairCount();

        public abstract List<? extends WebMsgProto.KVPairOrBuilder> getKvpairOrBuilderList();

        public abstract WebMsgProto.KVPairOrBuilder getKvpairOrBuilder(int paramInt);

        public abstract boolean hasGeoip();

        public abstract WebMsgProto.LocationGeoip getGeoip();

        public abstract WebMsgProto.LocationGeoipOrBuilder getGeoipOrBuilder();
    }

    public static final class MsgPack extends GeneratedMessage implements WebMsgProto.MsgPackOrBuilder {
        private static final MsgPack defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<MsgPack> PARSER = new AbstractParser() {
            public WebMsgProto.MsgPack parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.MsgPack(input, extensionRegistry);
            }
        };
        public static final int SITEITEM_FIELD_NUMBER = 1;
        private List<WebMsgProto.SiteItem> siteItem_;
        public static final int SITEURLITEM_FIELD_NUMBER = 2;
        private List<WebMsgProto.SiteUrlItem> siteUrlItem_;
        public static final int LOGACTIONITEM_FIELD_NUMBER = 3;
        private List<WebMsgProto.LogActionItem> logActionItem_;
        public static final int LINKVISITACTIONITEM_FIELD_NUMBER = 4;
        private List<WebMsgProto.LinkVisitActionItem> linkVisitActionItem_;
        public static final int LOGVISITITEM_FIELD_NUMBER = 5;
        private List<WebMsgProto.LogVisitItem> logVisitItem_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new MsgPack(true);
            defaultInstance.initFields();
        }

        private MsgPack(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private MsgPack(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static MsgPack getDefaultInstance() {
            return defaultInstance;
        }

        public MsgPack getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MsgPack(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 10:
                            if ((mutable_bitField0_ & 0x1) != 1) {
                                this.siteItem_ = new ArrayList();
                                mutable_bitField0_ |= 1;
                            }
                            this.siteItem_.add((WebMsgProto.SiteItem) input.readMessage(WebMsgProto.SiteItem.PARSER, extensionRegistry));
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.siteUrlItem_ = new ArrayList();
                                mutable_bitField0_ |= 2;
                            }
                            this.siteUrlItem_.add((WebMsgProto.SiteUrlItem) input.readMessage(WebMsgProto.SiteUrlItem.PARSER, extensionRegistry));
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.logActionItem_ = new ArrayList();
                                mutable_bitField0_ |= 4;
                            }
                            this.logActionItem_.add((WebMsgProto.LogActionItem) input.readMessage(WebMsgProto.LogActionItem.PARSER, extensionRegistry));
                            break;
                        case 34:
                            if ((mutable_bitField0_ & 0x8) != 8) {
                                this.linkVisitActionItem_ = new ArrayList();
                                mutable_bitField0_ |= 8;
                            }
                            this.linkVisitActionItem_.add((WebMsgProto.LinkVisitActionItem) input.readMessage(WebMsgProto.LinkVisitActionItem.PARSER, extensionRegistry));
                            break;
                        case 42:
                            if ((mutable_bitField0_ & 0x10) != 16) {
                                this.logVisitItem_ = new ArrayList();
                                mutable_bitField0_ |= 16;
                            }
                            this.logVisitItem_.add((WebMsgProto.LogVisitItem) input.readMessage(WebMsgProto.LogVisitItem.PARSER, extensionRegistry));
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x1) == 1) {
                    this.siteItem_ = Collections.unmodifiableList(this.siteItem_);
                }
                if ((mutable_bitField0_ & 0x2) == 2) {
                    this.siteUrlItem_ = Collections.unmodifiableList(this.siteUrlItem_);
                }
                if ((mutable_bitField0_ & 0x4) == 4) {
                    this.logActionItem_ = Collections.unmodifiableList(this.logActionItem_);
                }
                if ((mutable_bitField0_ & 0x8) == 8) {
                    this.linkVisitActionItem_ = Collections.unmodifiableList(this.linkVisitActionItem_);
                }
                if ((mutable_bitField0_ & 0x10) == 16) {
                    this.logVisitItem_ = Collections.unmodifiableList(this.logVisitItem_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_MsgPack_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_MsgPack_fieldAccessorTable.ensureFieldAccessorsInitialized(MsgPack.class, Builder.class);
        }

        public Parser<MsgPack> getParserForType() {
            return PARSER;
        }

        public List<WebMsgProto.SiteItem> getSiteItemList() {
            return this.siteItem_;
        }

        public List<? extends WebMsgProto.SiteItemOrBuilder> getSiteItemOrBuilderList() {
            return this.siteItem_;
        }

        public int getSiteItemCount() {
            return this.siteItem_.size();
        }

        public WebMsgProto.SiteItem getSiteItem(int index) {
            return (WebMsgProto.SiteItem) this.siteItem_.get(index);
        }

        public WebMsgProto.SiteItemOrBuilder getSiteItemOrBuilder(int index) {
            return (WebMsgProto.SiteItemOrBuilder) this.siteItem_.get(index);
        }

        public List<WebMsgProto.SiteUrlItem> getSiteUrlItemList() {
            return this.siteUrlItem_;
        }

        public List<? extends WebMsgProto.SiteUrlItemOrBuilder> getSiteUrlItemOrBuilderList() {
            return this.siteUrlItem_;
        }

        public int getSiteUrlItemCount() {
            return this.siteUrlItem_.size();
        }

        public WebMsgProto.SiteUrlItem getSiteUrlItem(int index) {
            return (WebMsgProto.SiteUrlItem) this.siteUrlItem_.get(index);
        }

        public WebMsgProto.SiteUrlItemOrBuilder getSiteUrlItemOrBuilder(int index) {
            return (WebMsgProto.SiteUrlItemOrBuilder) this.siteUrlItem_.get(index);
        }

        public List<WebMsgProto.LogActionItem> getLogActionItemList() {
            return this.logActionItem_;
        }

        public List<? extends WebMsgProto.LogActionItemOrBuilder> getLogActionItemOrBuilderList() {
            return this.logActionItem_;
        }

        public int getLogActionItemCount() {
            return this.logActionItem_.size();
        }

        public WebMsgProto.LogActionItem getLogActionItem(int index) {
            return (WebMsgProto.LogActionItem) this.logActionItem_.get(index);
        }

        public WebMsgProto.LogActionItemOrBuilder getLogActionItemOrBuilder(int index) {
            return (WebMsgProto.LogActionItemOrBuilder) this.logActionItem_.get(index);
        }

        public List<WebMsgProto.LinkVisitActionItem> getLinkVisitActionItemList() {
            return this.linkVisitActionItem_;
        }

        public List<? extends WebMsgProto.LinkVisitActionItemOrBuilder> getLinkVisitActionItemOrBuilderList() {
            return this.linkVisitActionItem_;
        }

        public int getLinkVisitActionItemCount() {
            return this.linkVisitActionItem_.size();
        }

        public WebMsgProto.LinkVisitActionItem getLinkVisitActionItem(int index) {
            return (WebMsgProto.LinkVisitActionItem) this.linkVisitActionItem_.get(index);
        }

        public WebMsgProto.LinkVisitActionItemOrBuilder getLinkVisitActionItemOrBuilder(int index) {
            return (WebMsgProto.LinkVisitActionItemOrBuilder) this.linkVisitActionItem_.get(index);
        }

        public List<WebMsgProto.LogVisitItem> getLogVisitItemList() {
            return this.logVisitItem_;
        }

        public List<? extends WebMsgProto.LogVisitItemOrBuilder> getLogVisitItemOrBuilderList() {
            return this.logVisitItem_;
        }

        public int getLogVisitItemCount() {
            return this.logVisitItem_.size();
        }

        public WebMsgProto.LogVisitItem getLogVisitItem(int index) {
            return (WebMsgProto.LogVisitItem) this.logVisitItem_.get(index);
        }

        public WebMsgProto.LogVisitItemOrBuilder getLogVisitItemOrBuilder(int index) {
            return (WebMsgProto.LogVisitItemOrBuilder) this.logVisitItem_.get(index);
        }

        private void initFields() {
            this.siteItem_ = Collections.emptyList();
            this.siteUrlItem_ = Collections.emptyList();
            this.logActionItem_ = Collections.emptyList();
            this.linkVisitActionItem_ = Collections.emptyList();
            this.logVisitItem_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            for (int i = 0; i < getSiteItemCount(); i++) {
                if (!getSiteItem(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i = 0; i < getSiteUrlItemCount(); i++) {
                if (!getSiteUrlItem(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i = 0; i < getLogActionItemCount(); i++) {
                if (!getLogActionItem(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i = 0; i < getLinkVisitActionItemCount(); i++) {
                if (!getLinkVisitActionItem(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i = 0; i < getLogVisitItemCount(); i++) {
                if (!getLogVisitItem(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.siteItem_.size(); i++) {
                output.writeMessage(1, (MessageLite) this.siteItem_.get(i));
            }
            for (int i = 0; i < this.siteUrlItem_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.siteUrlItem_.get(i));
            }
            for (int i = 0; i < this.logActionItem_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.logActionItem_.get(i));
            }
            for (int i = 0; i < this.linkVisitActionItem_.size(); i++) {
                output.writeMessage(4, (MessageLite) this.linkVisitActionItem_.get(i));
            }
            for (int i = 0; i < this.logVisitItem_.size(); i++) {
                output.writeMessage(5, (MessageLite) this.logVisitItem_.get(i));
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            for (int i = 0; i < this.siteItem_.size(); i++) {
                size = size + CodedOutputStream.computeMessageSize(1, (MessageLite) this.siteItem_.get(i));
            }
            for (int i = 0; i < this.siteUrlItem_.size(); i++) {
                size = size + CodedOutputStream.computeMessageSize(2, (MessageLite) this.siteUrlItem_.get(i));
            }
            for (int i = 0; i < this.logActionItem_.size(); i++) {
                size = size + CodedOutputStream.computeMessageSize(3, (MessageLite) this.logActionItem_.get(i));
            }
            for (int i = 0; i < this.linkVisitActionItem_.size(); i++) {
                size = size + CodedOutputStream.computeMessageSize(4, (MessageLite) this.linkVisitActionItem_.get(i));
            }
            for (int i = 0; i < this.logVisitItem_.size(); i++) {
                size = size + CodedOutputStream.computeMessageSize(5, (MessageLite) this.logVisitItem_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static MsgPack parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MsgPack) PARSER.parseFrom(data);
        }

        public static MsgPack parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MsgPack) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MsgPack parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MsgPack) PARSER.parseFrom(data);
        }

        public static MsgPack parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MsgPack) PARSER.parseFrom(data, extensionRegistry);
        }

        public static MsgPack parseFrom(InputStream input) throws IOException {
            return (MsgPack) PARSER.parseFrom(input);
        }

        public static MsgPack parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MsgPack) PARSER.parseFrom(input, extensionRegistry);
        }

        public static MsgPack parseDelimitedFrom(InputStream input) throws IOException {
            return (MsgPack) PARSER.parseDelimitedFrom(input);
        }

        public static MsgPack parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MsgPack) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static MsgPack parseFrom(CodedInputStream input) throws IOException {
            return (MsgPack) PARSER.parseFrom(input);
        }

        public static MsgPack parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MsgPack) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MsgPack prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.MsgPackOrBuilder {
            private int bitField0_;
            private List<WebMsgProto.SiteItem> siteItem_ = Collections.emptyList();
            private RepeatedFieldBuilder<WebMsgProto.SiteItem, WebMsgProto.SiteItem.Builder, WebMsgProto.SiteItemOrBuilder> siteItemBuilder_;
            private List<WebMsgProto.SiteUrlItem> siteUrlItem_ = Collections.emptyList();
            private RepeatedFieldBuilder<WebMsgProto.SiteUrlItem, WebMsgProto.SiteUrlItem.Builder, WebMsgProto.SiteUrlItemOrBuilder> siteUrlItemBuilder_;
            private List<WebMsgProto.LogActionItem> logActionItem_ = Collections.emptyList();
            private RepeatedFieldBuilder<WebMsgProto.LogActionItem, WebMsgProto.LogActionItem.Builder, WebMsgProto.LogActionItemOrBuilder> logActionItemBuilder_;
            private List<WebMsgProto.LinkVisitActionItem> linkVisitActionItem_ = Collections.emptyList();
            private RepeatedFieldBuilder<WebMsgProto.LinkVisitActionItem, WebMsgProto.LinkVisitActionItem.Builder, WebMsgProto.LinkVisitActionItemOrBuilder> linkVisitActionItemBuilder_;
            private List<WebMsgProto.LogVisitItem> logVisitItem_ = Collections.emptyList();
            private RepeatedFieldBuilder<WebMsgProto.LogVisitItem, WebMsgProto.LogVisitItem.Builder, WebMsgProto.LogVisitItemOrBuilder> logVisitItemBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_MsgPack_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_MsgPack_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.MsgPack.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WebMsgProto.MsgPack.alwaysUseFieldBuilders) {
                    getSiteItemFieldBuilder();
                    getSiteUrlItemFieldBuilder();
                    getLogActionItemFieldBuilder();
                    getLinkVisitActionItemFieldBuilder();
                    getLogVisitItemFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                if (this.siteItemBuilder_ == null) {
                    this.siteItem_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.siteItemBuilder_.clear();
                }
                if (this.siteUrlItemBuilder_ == null) {
                    this.siteUrlItem_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.siteUrlItemBuilder_.clear();
                }
                if (this.logActionItemBuilder_ == null) {
                    this.logActionItem_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.logActionItemBuilder_.clear();
                }
                if (this.linkVisitActionItemBuilder_ == null) {
                    this.linkVisitActionItem_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.linkVisitActionItemBuilder_.clear();
                }
                if (this.logVisitItemBuilder_ == null) {
                    this.logVisitItem_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.logVisitItemBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_MsgPack_descriptor;
            }

            public WebMsgProto.MsgPack getDefaultInstanceForType() {
                return WebMsgProto.MsgPack.getDefaultInstance();
            }

            public WebMsgProto.MsgPack build() {
                WebMsgProto.MsgPack result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.MsgPack buildPartial() {
                WebMsgProto.MsgPack result = new WebMsgProto.MsgPack(this);
                int from_bitField0_ = this.bitField0_;
                if (this.siteItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x1) == 1) {
                        this.siteItem_ = Collections.unmodifiableList(this.siteItem_);
                        this.bitField0_ &= -2;
                    }
                    result.siteItem_ = this.siteItem_;
                } else {
                    result.siteItem_ = this.siteItemBuilder_.build();
                }
                if (this.siteUrlItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.siteUrlItem_ = Collections.unmodifiableList(this.siteUrlItem_);
                        this.bitField0_ &= -3;
                    }
                    result.siteUrlItem_ = this.siteUrlItem_;
                } else {
                    result.siteUrlItem_ = this.siteUrlItemBuilder_.build();
                }
                if (this.logActionItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.logActionItem_ = Collections.unmodifiableList(this.logActionItem_);
                        this.bitField0_ &= -5;
                    }
                    result.logActionItem_ = this.logActionItem_;
                } else {
                    result.logActionItem_ = this.logActionItemBuilder_.build();
                }
                if (this.linkVisitActionItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x8) == 8) {
                        this.linkVisitActionItem_ = Collections.unmodifiableList(this.linkVisitActionItem_);
                        this.bitField0_ &= -9;
                    }
                    result.linkVisitActionItem_ = this.linkVisitActionItem_;
                } else {
                    result.linkVisitActionItem_ = this.linkVisitActionItemBuilder_.build();
                }
                if (this.logVisitItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) == 16) {
                        this.logVisitItem_ = Collections.unmodifiableList(this.logVisitItem_);
                        this.bitField0_ &= -17;
                    }
                    result.logVisitItem_ = this.logVisitItem_;
                } else {
                    result.logVisitItem_ = this.logVisitItemBuilder_.build();
                }
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.MsgPack)) {
                    return mergeFrom((WebMsgProto.MsgPack) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.MsgPack other) {
                if (other == WebMsgProto.MsgPack.getDefaultInstance())
                    return this;
                if (this.siteItemBuilder_ == null) {
                    if (!other.siteItem_.isEmpty()) {
                        if (this.siteItem_.isEmpty()) {
                            this.siteItem_ = other.siteItem_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSiteItemIsMutable();
                            this.siteItem_.addAll(other.siteItem_);
                        }
                        onChanged();
                    }
                } else if (!other.siteItem_.isEmpty()) {
                    if (this.siteItemBuilder_.isEmpty()) {
                        this.siteItemBuilder_.dispose();
                        this.siteItemBuilder_ = null;
                        this.siteItem_ = other.siteItem_;
                        this.bitField0_ &= -2;
                        this.siteItemBuilder_ = (WebMsgProto.MsgPack.alwaysUseFieldBuilders ? getSiteItemFieldBuilder() : null);
                    } else {
                        this.siteItemBuilder_.addAllMessages(other.siteItem_);
                    }
                }

                if (this.siteUrlItemBuilder_ == null) {
                    if (!other.siteUrlItem_.isEmpty()) {
                        if (this.siteUrlItem_.isEmpty()) {
                            this.siteUrlItem_ = other.siteUrlItem_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureSiteUrlItemIsMutable();
                            this.siteUrlItem_.addAll(other.siteUrlItem_);
                        }
                        onChanged();
                    }
                } else if (!other.siteUrlItem_.isEmpty()) {
                    if (this.siteUrlItemBuilder_.isEmpty()) {
                        this.siteUrlItemBuilder_.dispose();
                        this.siteUrlItemBuilder_ = null;
                        this.siteUrlItem_ = other.siteUrlItem_;
                        this.bitField0_ &= -3;
                        this.siteUrlItemBuilder_ = (WebMsgProto.MsgPack.alwaysUseFieldBuilders ? getSiteUrlItemFieldBuilder() : null);
                    } else {
                        this.siteUrlItemBuilder_.addAllMessages(other.siteUrlItem_);
                    }
                }

                if (this.logActionItemBuilder_ == null) {
                    if (!other.logActionItem_.isEmpty()) {
                        if (this.logActionItem_.isEmpty()) {
                            this.logActionItem_ = other.logActionItem_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureLogActionItemIsMutable();
                            this.logActionItem_.addAll(other.logActionItem_);
                        }
                        onChanged();
                    }
                } else if (!other.logActionItem_.isEmpty()) {
                    if (this.logActionItemBuilder_.isEmpty()) {
                        this.logActionItemBuilder_.dispose();
                        this.logActionItemBuilder_ = null;
                        this.logActionItem_ = other.logActionItem_;
                        this.bitField0_ &= -5;
                        this.logActionItemBuilder_ = (WebMsgProto.MsgPack.alwaysUseFieldBuilders ? getLogActionItemFieldBuilder() : null);
                    } else {
                        this.logActionItemBuilder_.addAllMessages(other.logActionItem_);
                    }
                }

                if (this.linkVisitActionItemBuilder_ == null) {
                    if (!other.linkVisitActionItem_.isEmpty()) {
                        if (this.linkVisitActionItem_.isEmpty()) {
                            this.linkVisitActionItem_ = other.linkVisitActionItem_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureLinkVisitActionItemIsMutable();
                            this.linkVisitActionItem_.addAll(other.linkVisitActionItem_);
                        }
                        onChanged();
                    }
                } else if (!other.linkVisitActionItem_.isEmpty()) {
                    if (this.linkVisitActionItemBuilder_.isEmpty()) {
                        this.linkVisitActionItemBuilder_.dispose();
                        this.linkVisitActionItemBuilder_ = null;
                        this.linkVisitActionItem_ = other.linkVisitActionItem_;
                        this.bitField0_ &= -9;
                        this.linkVisitActionItemBuilder_ = (WebMsgProto.MsgPack.alwaysUseFieldBuilders ? getLinkVisitActionItemFieldBuilder() : null);
                    } else {
                        this.linkVisitActionItemBuilder_.addAllMessages(other.linkVisitActionItem_);
                    }
                }

                if (this.logVisitItemBuilder_ == null) {
                    if (!other.logVisitItem_.isEmpty()) {
                        if (this.logVisitItem_.isEmpty()) {
                            this.logVisitItem_ = other.logVisitItem_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureLogVisitItemIsMutable();
                            this.logVisitItem_.addAll(other.logVisitItem_);
                        }
                        onChanged();
                    }
                } else if (!other.logVisitItem_.isEmpty()) {
                    if (this.logVisitItemBuilder_.isEmpty()) {
                        this.logVisitItemBuilder_.dispose();
                        this.logVisitItemBuilder_ = null;
                        this.logVisitItem_ = other.logVisitItem_;
                        this.bitField0_ &= -17;
                        this.logVisitItemBuilder_ = (WebMsgProto.MsgPack.alwaysUseFieldBuilders ? getLogVisitItemFieldBuilder() : null);
                    } else {
                        this.logVisitItemBuilder_.addAllMessages(other.logVisitItem_);
                    }
                }

                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                for (int i = 0; i < getSiteItemCount(); i++) {
                    if (!getSiteItem(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i = 0; i < getSiteUrlItemCount(); i++) {
                    if (!getSiteUrlItem(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i = 0; i < getLogActionItemCount(); i++) {
                    if (!getLogActionItem(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i = 0; i < getLinkVisitActionItemCount(); i++) {
                    if (!getLinkVisitActionItem(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i = 0; i < getLogVisitItemCount(); i++) {
                    if (!getLogVisitItem(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.MsgPack parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.MsgPack) WebMsgProto.MsgPack.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.MsgPack) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private void ensureSiteItemIsMutable() {
                if ((this.bitField0_ & 0x1) != 1) {
                    this.siteItem_ = new ArrayList(this.siteItem_);
                    this.bitField0_ |= 1;
                }
            }

            public List<WebMsgProto.SiteItem> getSiteItemList() {
                if (this.siteItemBuilder_ == null) {
                    return Collections.unmodifiableList(this.siteItem_);
                }
                return this.siteItemBuilder_.getMessageList();
            }

            public int getSiteItemCount() {
                if (this.siteItemBuilder_ == null) {
                    return this.siteItem_.size();
                }
                return this.siteItemBuilder_.getCount();
            }

            public WebMsgProto.SiteItem getSiteItem(int index) {
                if (this.siteItemBuilder_ == null) {
                    return (WebMsgProto.SiteItem) this.siteItem_.get(index);
                }
                return (WebMsgProto.SiteItem) this.siteItemBuilder_.getMessage(index);
            }

            public Builder setSiteItem(int index, WebMsgProto.SiteItem value) {
                if (this.siteItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSiteItemIsMutable();
                    this.siteItem_.set(index, value);
                    onChanged();
                } else {
                    this.siteItemBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setSiteItem(int index, WebMsgProto.SiteItem.Builder builderForValue) {
                if (this.siteItemBuilder_ == null) {
                    ensureSiteItemIsMutable();
                    this.siteItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.siteItemBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSiteItem(WebMsgProto.SiteItem value) {
                if (this.siteItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSiteItemIsMutable();
                    this.siteItem_.add(value);
                    onChanged();
                } else {
                    this.siteItemBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addSiteItem(int index, WebMsgProto.SiteItem value) {
                if (this.siteItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSiteItemIsMutable();
                    this.siteItem_.add(index, value);
                    onChanged();
                } else {
                    this.siteItemBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addSiteItem(WebMsgProto.SiteItem.Builder builderForValue) {
                if (this.siteItemBuilder_ == null) {
                    ensureSiteItemIsMutable();
                    this.siteItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.siteItemBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSiteItem(int index, WebMsgProto.SiteItem.Builder builderForValue) {
                if (this.siteItemBuilder_ == null) {
                    ensureSiteItemIsMutable();
                    this.siteItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.siteItemBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSiteItem(Iterable<? extends WebMsgProto.SiteItem> values) {
                if (this.siteItemBuilder_ == null) {
                    ensureSiteItemIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.siteItem_);
                    onChanged();
                } else {
                    this.siteItemBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSiteItem() {
                if (this.siteItemBuilder_ == null) {
                    this.siteItem_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.siteItemBuilder_.clear();
                }
                return this;
            }

            public Builder removeSiteItem(int index) {
                if (this.siteItemBuilder_ == null) {
                    ensureSiteItemIsMutable();
                    this.siteItem_.remove(index);
                    onChanged();
                } else {
                    this.siteItemBuilder_.remove(index);
                }
                return this;
            }

            public WebMsgProto.SiteItem.Builder getSiteItemBuilder(int index) {
                return (WebMsgProto.SiteItem.Builder) getSiteItemFieldBuilder().getBuilder(index);
            }

            public WebMsgProto.SiteItemOrBuilder getSiteItemOrBuilder(int index) {
                if (this.siteItemBuilder_ == null)
                    return (WebMsgProto.SiteItemOrBuilder) this.siteItem_.get(index);
                return (WebMsgProto.SiteItemOrBuilder) this.siteItemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends WebMsgProto.SiteItemOrBuilder> getSiteItemOrBuilderList() {
                if (this.siteItemBuilder_ != null) {
                    return this.siteItemBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.siteItem_);
            }

            public WebMsgProto.SiteItem.Builder addSiteItemBuilder() {
                return (WebMsgProto.SiteItem.Builder) getSiteItemFieldBuilder().addBuilder(WebMsgProto.SiteItem.getDefaultInstance());
            }

            public WebMsgProto.SiteItem.Builder addSiteItemBuilder(int index) {
                return (WebMsgProto.SiteItem.Builder) getSiteItemFieldBuilder().addBuilder(index, WebMsgProto.SiteItem.getDefaultInstance());
            }

            public List<WebMsgProto.SiteItem.Builder> getSiteItemBuilderList() {
                return getSiteItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<WebMsgProto.SiteItem, WebMsgProto.SiteItem.Builder, WebMsgProto.SiteItemOrBuilder> getSiteItemFieldBuilder() {
                if (this.siteItemBuilder_ == null) {
                    this.siteItemBuilder_ = new RepeatedFieldBuilder(this.siteItem_, (this.bitField0_ & 0x1) == 1, getParentForChildren(), isClean());
                    this.siteItem_ = null;
                }
                return this.siteItemBuilder_;
            }

            private void ensureSiteUrlItemIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.siteUrlItem_ = new ArrayList(this.siteUrlItem_);
                    this.bitField0_ |= 2;
                }
            }

            public List<WebMsgProto.SiteUrlItem> getSiteUrlItemList() {
                if (this.siteUrlItemBuilder_ == null) {
                    return Collections.unmodifiableList(this.siteUrlItem_);
                }
                return this.siteUrlItemBuilder_.getMessageList();
            }

            public int getSiteUrlItemCount() {
                if (this.siteUrlItemBuilder_ == null) {
                    return this.siteUrlItem_.size();
                }
                return this.siteUrlItemBuilder_.getCount();
            }

            public WebMsgProto.SiteUrlItem getSiteUrlItem(int index) {
                if (this.siteUrlItemBuilder_ == null) {
                    return (WebMsgProto.SiteUrlItem) this.siteUrlItem_.get(index);
                }
                return (WebMsgProto.SiteUrlItem) this.siteUrlItemBuilder_.getMessage(index);
            }

            public Builder setSiteUrlItem(int index, WebMsgProto.SiteUrlItem value) {
                if (this.siteUrlItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSiteUrlItemIsMutable();
                    this.siteUrlItem_.set(index, value);
                    onChanged();
                } else {
                    this.siteUrlItemBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setSiteUrlItem(int index, WebMsgProto.SiteUrlItem.Builder builderForValue) {
                if (this.siteUrlItemBuilder_ == null) {
                    ensureSiteUrlItemIsMutable();
                    this.siteUrlItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.siteUrlItemBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSiteUrlItem(WebMsgProto.SiteUrlItem value) {
                if (this.siteUrlItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSiteUrlItemIsMutable();
                    this.siteUrlItem_.add(value);
                    onChanged();
                } else {
                    this.siteUrlItemBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addSiteUrlItem(int index, WebMsgProto.SiteUrlItem value) {
                if (this.siteUrlItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSiteUrlItemIsMutable();
                    this.siteUrlItem_.add(index, value);
                    onChanged();
                } else {
                    this.siteUrlItemBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addSiteUrlItem(WebMsgProto.SiteUrlItem.Builder builderForValue) {
                if (this.siteUrlItemBuilder_ == null) {
                    ensureSiteUrlItemIsMutable();
                    this.siteUrlItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.siteUrlItemBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSiteUrlItem(int index, WebMsgProto.SiteUrlItem.Builder builderForValue) {
                if (this.siteUrlItemBuilder_ == null) {
                    ensureSiteUrlItemIsMutable();
                    this.siteUrlItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.siteUrlItemBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSiteUrlItem(Iterable<? extends WebMsgProto.SiteUrlItem> values) {
                if (this.siteUrlItemBuilder_ == null) {
                    ensureSiteUrlItemIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.siteUrlItem_);
                    onChanged();
                } else {
                    this.siteUrlItemBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSiteUrlItem() {
                if (this.siteUrlItemBuilder_ == null) {
                    this.siteUrlItem_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.siteUrlItemBuilder_.clear();
                }
                return this;
            }

            public Builder removeSiteUrlItem(int index) {
                if (this.siteUrlItemBuilder_ == null) {
                    ensureSiteUrlItemIsMutable();
                    this.siteUrlItem_.remove(index);
                    onChanged();
                } else {
                    this.siteUrlItemBuilder_.remove(index);
                }
                return this;
            }

            public WebMsgProto.SiteUrlItem.Builder getSiteUrlItemBuilder(int index) {
                return (WebMsgProto.SiteUrlItem.Builder) getSiteUrlItemFieldBuilder().getBuilder(index);
            }

            public WebMsgProto.SiteUrlItemOrBuilder getSiteUrlItemOrBuilder(int index) {
                if (this.siteUrlItemBuilder_ == null)
                    return (WebMsgProto.SiteUrlItemOrBuilder) this.siteUrlItem_.get(index);
                return (WebMsgProto.SiteUrlItemOrBuilder) this.siteUrlItemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends WebMsgProto.SiteUrlItemOrBuilder> getSiteUrlItemOrBuilderList() {
                if (this.siteUrlItemBuilder_ != null) {
                    return this.siteUrlItemBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.siteUrlItem_);
            }

            public WebMsgProto.SiteUrlItem.Builder addSiteUrlItemBuilder() {
                return (WebMsgProto.SiteUrlItem.Builder) getSiteUrlItemFieldBuilder().addBuilder(WebMsgProto.SiteUrlItem.getDefaultInstance());
            }

            public WebMsgProto.SiteUrlItem.Builder addSiteUrlItemBuilder(int index) {
                return (WebMsgProto.SiteUrlItem.Builder) getSiteUrlItemFieldBuilder().addBuilder(index, WebMsgProto.SiteUrlItem.getDefaultInstance());
            }

            public List<WebMsgProto.SiteUrlItem.Builder> getSiteUrlItemBuilderList() {
                return getSiteUrlItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<WebMsgProto.SiteUrlItem, WebMsgProto.SiteUrlItem.Builder, WebMsgProto.SiteUrlItemOrBuilder> getSiteUrlItemFieldBuilder() {
                if (this.siteUrlItemBuilder_ == null) {
                    this.siteUrlItemBuilder_ = new RepeatedFieldBuilder(this.siteUrlItem_, (this.bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
                    this.siteUrlItem_ = null;
                }
                return this.siteUrlItemBuilder_;
            }

            private void ensureLogActionItemIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.logActionItem_ = new ArrayList(this.logActionItem_);
                    this.bitField0_ |= 4;
                }
            }

            public List<WebMsgProto.LogActionItem> getLogActionItemList() {
                if (this.logActionItemBuilder_ == null) {
                    return Collections.unmodifiableList(this.logActionItem_);
                }
                return this.logActionItemBuilder_.getMessageList();
            }

            public int getLogActionItemCount() {
                if (this.logActionItemBuilder_ == null) {
                    return this.logActionItem_.size();
                }
                return this.logActionItemBuilder_.getCount();
            }

            public WebMsgProto.LogActionItem getLogActionItem(int index) {
                if (this.logActionItemBuilder_ == null) {
                    return (WebMsgProto.LogActionItem) this.logActionItem_.get(index);
                }
                return (WebMsgProto.LogActionItem) this.logActionItemBuilder_.getMessage(index);
            }

            public Builder setLogActionItem(int index, WebMsgProto.LogActionItem value) {
                if (this.logActionItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLogActionItemIsMutable();
                    this.logActionItem_.set(index, value);
                    onChanged();
                } else {
                    this.logActionItemBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setLogActionItem(int index, WebMsgProto.LogActionItem.Builder builderForValue) {
                if (this.logActionItemBuilder_ == null) {
                    ensureLogActionItemIsMutable();
                    this.logActionItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.logActionItemBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLogActionItem(WebMsgProto.LogActionItem value) {
                if (this.logActionItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLogActionItemIsMutable();
                    this.logActionItem_.add(value);
                    onChanged();
                } else {
                    this.logActionItemBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addLogActionItem(int index, WebMsgProto.LogActionItem value) {
                if (this.logActionItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLogActionItemIsMutable();
                    this.logActionItem_.add(index, value);
                    onChanged();
                } else {
                    this.logActionItemBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addLogActionItem(WebMsgProto.LogActionItem.Builder builderForValue) {
                if (this.logActionItemBuilder_ == null) {
                    ensureLogActionItemIsMutable();
                    this.logActionItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.logActionItemBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLogActionItem(int index, WebMsgProto.LogActionItem.Builder builderForValue) {
                if (this.logActionItemBuilder_ == null) {
                    ensureLogActionItemIsMutable();
                    this.logActionItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.logActionItemBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLogActionItem(Iterable<? extends WebMsgProto.LogActionItem> values) {
                if (this.logActionItemBuilder_ == null) {
                    ensureLogActionItemIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.logActionItem_);
                    onChanged();
                } else {
                    this.logActionItemBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLogActionItem() {
                if (this.logActionItemBuilder_ == null) {
                    this.logActionItem_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.logActionItemBuilder_.clear();
                }
                return this;
            }

            public Builder removeLogActionItem(int index) {
                if (this.logActionItemBuilder_ == null) {
                    ensureLogActionItemIsMutable();
                    this.logActionItem_.remove(index);
                    onChanged();
                } else {
                    this.logActionItemBuilder_.remove(index);
                }
                return this;
            }

            public WebMsgProto.LogActionItem.Builder getLogActionItemBuilder(int index) {
                return (WebMsgProto.LogActionItem.Builder) getLogActionItemFieldBuilder().getBuilder(index);
            }

            public WebMsgProto.LogActionItemOrBuilder getLogActionItemOrBuilder(int index) {
                if (this.logActionItemBuilder_ == null)
                    return (WebMsgProto.LogActionItemOrBuilder) this.logActionItem_.get(index);
                return (WebMsgProto.LogActionItemOrBuilder) this.logActionItemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends WebMsgProto.LogActionItemOrBuilder> getLogActionItemOrBuilderList() {
                if (this.logActionItemBuilder_ != null) {
                    return this.logActionItemBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.logActionItem_);
            }

            public WebMsgProto.LogActionItem.Builder addLogActionItemBuilder() {
                return (WebMsgProto.LogActionItem.Builder) getLogActionItemFieldBuilder().addBuilder(WebMsgProto.LogActionItem.getDefaultInstance());
            }

            public WebMsgProto.LogActionItem.Builder addLogActionItemBuilder(int index) {
                return (WebMsgProto.LogActionItem.Builder) getLogActionItemFieldBuilder().addBuilder(index, WebMsgProto.LogActionItem.getDefaultInstance());
            }

            public List<WebMsgProto.LogActionItem.Builder> getLogActionItemBuilderList() {
                return getLogActionItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<WebMsgProto.LogActionItem, WebMsgProto.LogActionItem.Builder, WebMsgProto.LogActionItemOrBuilder> getLogActionItemFieldBuilder() {
                if (this.logActionItemBuilder_ == null) {
                    this.logActionItemBuilder_ = new RepeatedFieldBuilder(this.logActionItem_, (this.bitField0_ & 0x4) == 4, getParentForChildren(), isClean());
                    this.logActionItem_ = null;
                }
                return this.logActionItemBuilder_;
            }

            private void ensureLinkVisitActionItemIsMutable() {
                if ((this.bitField0_ & 0x8) != 8) {
                    this.linkVisitActionItem_ = new ArrayList(this.linkVisitActionItem_);
                    this.bitField0_ |= 8;
                }
            }

            public List<WebMsgProto.LinkVisitActionItem> getLinkVisitActionItemList() {
                if (this.linkVisitActionItemBuilder_ == null) {
                    return Collections.unmodifiableList(this.linkVisitActionItem_);
                }
                return this.linkVisitActionItemBuilder_.getMessageList();
            }

            public int getLinkVisitActionItemCount() {
                if (this.linkVisitActionItemBuilder_ == null) {
                    return this.linkVisitActionItem_.size();
                }
                return this.linkVisitActionItemBuilder_.getCount();
            }

            public WebMsgProto.LinkVisitActionItem getLinkVisitActionItem(int index) {
                if (this.linkVisitActionItemBuilder_ == null) {
                    return (WebMsgProto.LinkVisitActionItem) this.linkVisitActionItem_.get(index);
                }
                return (WebMsgProto.LinkVisitActionItem) this.linkVisitActionItemBuilder_.getMessage(index);
            }

            public Builder setLinkVisitActionItem(int index, WebMsgProto.LinkVisitActionItem value) {
                if (this.linkVisitActionItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLinkVisitActionItemIsMutable();
                    this.linkVisitActionItem_.set(index, value);
                    onChanged();
                } else {
                    this.linkVisitActionItemBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setLinkVisitActionItem(int index, WebMsgProto.LinkVisitActionItem.Builder builderForValue) {
                if (this.linkVisitActionItemBuilder_ == null) {
                    ensureLinkVisitActionItemIsMutable();
                    this.linkVisitActionItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.linkVisitActionItemBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLinkVisitActionItem(WebMsgProto.LinkVisitActionItem value) {
                if (this.linkVisitActionItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLinkVisitActionItemIsMutable();
                    this.linkVisitActionItem_.add(value);
                    onChanged();
                } else {
                    this.linkVisitActionItemBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addLinkVisitActionItem(int index, WebMsgProto.LinkVisitActionItem value) {
                if (this.linkVisitActionItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLinkVisitActionItemIsMutable();
                    this.linkVisitActionItem_.add(index, value);
                    onChanged();
                } else {
                    this.linkVisitActionItemBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addLinkVisitActionItem(WebMsgProto.LinkVisitActionItem.Builder builderForValue) {
                if (this.linkVisitActionItemBuilder_ == null) {
                    ensureLinkVisitActionItemIsMutable();
                    this.linkVisitActionItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.linkVisitActionItemBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLinkVisitActionItem(int index, WebMsgProto.LinkVisitActionItem.Builder builderForValue) {
                if (this.linkVisitActionItemBuilder_ == null) {
                    ensureLinkVisitActionItemIsMutable();
                    this.linkVisitActionItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.linkVisitActionItemBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLinkVisitActionItem(Iterable<? extends WebMsgProto.LinkVisitActionItem> values) {
                if (this.linkVisitActionItemBuilder_ == null) {
                    ensureLinkVisitActionItemIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.linkVisitActionItem_);
                    onChanged();
                } else {
                    this.linkVisitActionItemBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLinkVisitActionItem() {
                if (this.linkVisitActionItemBuilder_ == null) {
                    this.linkVisitActionItem_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.linkVisitActionItemBuilder_.clear();
                }
                return this;
            }

            public Builder removeLinkVisitActionItem(int index) {
                if (this.linkVisitActionItemBuilder_ == null) {
                    ensureLinkVisitActionItemIsMutable();
                    this.linkVisitActionItem_.remove(index);
                    onChanged();
                } else {
                    this.linkVisitActionItemBuilder_.remove(index);
                }
                return this;
            }

            public WebMsgProto.LinkVisitActionItem.Builder getLinkVisitActionItemBuilder(int index) {
                return (WebMsgProto.LinkVisitActionItem.Builder) getLinkVisitActionItemFieldBuilder().getBuilder(index);
            }

            public WebMsgProto.LinkVisitActionItemOrBuilder getLinkVisitActionItemOrBuilder(int index) {
                if (this.linkVisitActionItemBuilder_ == null)
                    return (WebMsgProto.LinkVisitActionItemOrBuilder) this.linkVisitActionItem_.get(index);
                return (WebMsgProto.LinkVisitActionItemOrBuilder) this.linkVisitActionItemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends WebMsgProto.LinkVisitActionItemOrBuilder> getLinkVisitActionItemOrBuilderList() {
                if (this.linkVisitActionItemBuilder_ != null) {
                    return this.linkVisitActionItemBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.linkVisitActionItem_);
            }

            public WebMsgProto.LinkVisitActionItem.Builder addLinkVisitActionItemBuilder() {
                return (WebMsgProto.LinkVisitActionItem.Builder) getLinkVisitActionItemFieldBuilder().addBuilder(WebMsgProto.LinkVisitActionItem.getDefaultInstance());
            }

            public WebMsgProto.LinkVisitActionItem.Builder addLinkVisitActionItemBuilder(int index) {
                return (WebMsgProto.LinkVisitActionItem.Builder) getLinkVisitActionItemFieldBuilder().addBuilder(index, WebMsgProto.LinkVisitActionItem.getDefaultInstance());
            }

            public List<WebMsgProto.LinkVisitActionItem.Builder> getLinkVisitActionItemBuilderList() {
                return getLinkVisitActionItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<WebMsgProto.LinkVisitActionItem, WebMsgProto.LinkVisitActionItem.Builder, WebMsgProto.LinkVisitActionItemOrBuilder> getLinkVisitActionItemFieldBuilder() {
                if (this.linkVisitActionItemBuilder_ == null) {
                    this.linkVisitActionItemBuilder_ = new RepeatedFieldBuilder(this.linkVisitActionItem_, (this.bitField0_ & 0x8) == 8, getParentForChildren(), isClean());
                    this.linkVisitActionItem_ = null;
                }
                return this.linkVisitActionItemBuilder_;
            }

            private void ensureLogVisitItemIsMutable() {
                if ((this.bitField0_ & 0x10) != 16) {
                    this.logVisitItem_ = new ArrayList(this.logVisitItem_);
                    this.bitField0_ |= 16;
                }
            }

            public List<WebMsgProto.LogVisitItem> getLogVisitItemList() {
                if (this.logVisitItemBuilder_ == null) {
                    return Collections.unmodifiableList(this.logVisitItem_);
                }
                return this.logVisitItemBuilder_.getMessageList();
            }

            public int getLogVisitItemCount() {
                if (this.logVisitItemBuilder_ == null) {
                    return this.logVisitItem_.size();
                }
                return this.logVisitItemBuilder_.getCount();
            }

            public WebMsgProto.LogVisitItem getLogVisitItem(int index) {
                if (this.logVisitItemBuilder_ == null) {
                    return (WebMsgProto.LogVisitItem) this.logVisitItem_.get(index);
                }
                return (WebMsgProto.LogVisitItem) this.logVisitItemBuilder_.getMessage(index);
            }

            public Builder setLogVisitItem(int index, WebMsgProto.LogVisitItem value) {
                if (this.logVisitItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLogVisitItemIsMutable();
                    this.logVisitItem_.set(index, value);
                    onChanged();
                } else {
                    this.logVisitItemBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setLogVisitItem(int index, WebMsgProto.LogVisitItem.Builder builderForValue) {
                if (this.logVisitItemBuilder_ == null) {
                    ensureLogVisitItemIsMutable();
                    this.logVisitItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.logVisitItemBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLogVisitItem(WebMsgProto.LogVisitItem value) {
                if (this.logVisitItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLogVisitItemIsMutable();
                    this.logVisitItem_.add(value);
                    onChanged();
                } else {
                    this.logVisitItemBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addLogVisitItem(int index, WebMsgProto.LogVisitItem value) {
                if (this.logVisitItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLogVisitItemIsMutable();
                    this.logVisitItem_.add(index, value);
                    onChanged();
                } else {
                    this.logVisitItemBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addLogVisitItem(WebMsgProto.LogVisitItem.Builder builderForValue) {
                if (this.logVisitItemBuilder_ == null) {
                    ensureLogVisitItemIsMutable();
                    this.logVisitItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.logVisitItemBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLogVisitItem(int index, WebMsgProto.LogVisitItem.Builder builderForValue) {
                if (this.logVisitItemBuilder_ == null) {
                    ensureLogVisitItemIsMutable();
                    this.logVisitItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.logVisitItemBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLogVisitItem(Iterable<? extends WebMsgProto.LogVisitItem> values) {
                if (this.logVisitItemBuilder_ == null) {
                    ensureLogVisitItemIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.logVisitItem_);
                    onChanged();
                } else {
                    this.logVisitItemBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLogVisitItem() {
                if (this.logVisitItemBuilder_ == null) {
                    this.logVisitItem_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.logVisitItemBuilder_.clear();
                }
                return this;
            }

            public Builder removeLogVisitItem(int index) {
                if (this.logVisitItemBuilder_ == null) {
                    ensureLogVisitItemIsMutable();
                    this.logVisitItem_.remove(index);
                    onChanged();
                } else {
                    this.logVisitItemBuilder_.remove(index);
                }
                return this;
            }

            public WebMsgProto.LogVisitItem.Builder getLogVisitItemBuilder(int index) {
                return (WebMsgProto.LogVisitItem.Builder) getLogVisitItemFieldBuilder().getBuilder(index);
            }

            public WebMsgProto.LogVisitItemOrBuilder getLogVisitItemOrBuilder(int index) {
                if (this.logVisitItemBuilder_ == null)
                    return (WebMsgProto.LogVisitItemOrBuilder) this.logVisitItem_.get(index);
                return (WebMsgProto.LogVisitItemOrBuilder) this.logVisitItemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends WebMsgProto.LogVisitItemOrBuilder> getLogVisitItemOrBuilderList() {
                if (this.logVisitItemBuilder_ != null) {
                    return this.logVisitItemBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.logVisitItem_);
            }

            public WebMsgProto.LogVisitItem.Builder addLogVisitItemBuilder() {
                return (WebMsgProto.LogVisitItem.Builder) getLogVisitItemFieldBuilder().addBuilder(WebMsgProto.LogVisitItem.getDefaultInstance());
            }

            public WebMsgProto.LogVisitItem.Builder addLogVisitItemBuilder(int index) {
                return (WebMsgProto.LogVisitItem.Builder) getLogVisitItemFieldBuilder().addBuilder(index, WebMsgProto.LogVisitItem.getDefaultInstance());
            }

            public List<WebMsgProto.LogVisitItem.Builder> getLogVisitItemBuilderList() {
                return getLogVisitItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<WebMsgProto.LogVisitItem, WebMsgProto.LogVisitItem.Builder, WebMsgProto.LogVisitItemOrBuilder> getLogVisitItemFieldBuilder() {
                if (this.logVisitItemBuilder_ == null) {
                    this.logVisitItemBuilder_ = new RepeatedFieldBuilder(this.logVisitItem_, (this.bitField0_ & 0x10) == 16, getParentForChildren(), isClean());
                    this.logVisitItem_ = null;
                }
                return this.logVisitItemBuilder_;
            }
        }
    }

    public static abstract interface MsgPackOrBuilder extends MessageOrBuilder {
        public abstract List<WebMsgProto.SiteItem> getSiteItemList();

        public abstract WebMsgProto.SiteItem getSiteItem(int paramInt);

        public abstract int getSiteItemCount();

        public abstract List<? extends WebMsgProto.SiteItemOrBuilder> getSiteItemOrBuilderList();

        public abstract WebMsgProto.SiteItemOrBuilder getSiteItemOrBuilder(int paramInt);

        public abstract List<WebMsgProto.SiteUrlItem> getSiteUrlItemList();

        public abstract WebMsgProto.SiteUrlItem getSiteUrlItem(int paramInt);

        public abstract int getSiteUrlItemCount();

        public abstract List<? extends WebMsgProto.SiteUrlItemOrBuilder> getSiteUrlItemOrBuilderList();

        public abstract WebMsgProto.SiteUrlItemOrBuilder getSiteUrlItemOrBuilder(int paramInt);

        public abstract List<WebMsgProto.LogActionItem> getLogActionItemList();

        public abstract WebMsgProto.LogActionItem getLogActionItem(int paramInt);

        public abstract int getLogActionItemCount();

        public abstract List<? extends WebMsgProto.LogActionItemOrBuilder> getLogActionItemOrBuilderList();

        public abstract WebMsgProto.LogActionItemOrBuilder getLogActionItemOrBuilder(int paramInt);

        public abstract List<WebMsgProto.LinkVisitActionItem> getLinkVisitActionItemList();

        public abstract WebMsgProto.LinkVisitActionItem getLinkVisitActionItem(int paramInt);

        public abstract int getLinkVisitActionItemCount();

        public abstract List<? extends WebMsgProto.LinkVisitActionItemOrBuilder> getLinkVisitActionItemOrBuilderList();

        public abstract WebMsgProto.LinkVisitActionItemOrBuilder getLinkVisitActionItemOrBuilder(int paramInt);

        public abstract List<WebMsgProto.LogVisitItem> getLogVisitItemList();

        public abstract WebMsgProto.LogVisitItem getLogVisitItem(int paramInt);

        public abstract int getLogVisitItemCount();

        public abstract List<? extends WebMsgProto.LogVisitItemOrBuilder> getLogVisitItemOrBuilderList();

        public abstract WebMsgProto.LogVisitItemOrBuilder getLogVisitItemOrBuilder(int paramInt);
    }

    public static final class Referer extends GeneratedMessage implements WebMsgProto.RefererOrBuilder {
        private static final Referer defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<Referer> PARSER = new AbstractParser() {
            public WebMsgProto.Referer parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.Referer(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int NAME_FIELD_NUMBER = 2;
        private Object name_;
        public static final int URL_FIELD_NUMBER = 3;
        private Object url_;
        public static final int KEYWORD_FIELD_NUMBER = 4;
        private Object keyword_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new Referer(true);
            defaultInstance.initFields();
        }

        private Referer(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private Referer(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Referer getDefaultInstance() {
            return defaultInstance;
        }

        public Referer getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Referer(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.type_ = input.readInt32();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.name_ = input.readBytes();
                            break;
                        case 26:
                            this.bitField0_ |= 4;
                            this.url_ = input.readBytes();
                            break;
                        case 34:
                            this.bitField0_ |= 8;
                            this.keyword_ = input.readBytes();
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_Referer_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_Referer_fieldAccessorTable.ensureFieldAccessorsInitialized(Referer.class, Builder.class);
        }

        public Parser<Referer> getParserForType() {
            return PARSER;
        }

        public boolean hasType() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 0x2) == 2;
        }

        public String getName() {
            Object ref = this.name_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.name_ = s;
            }
            return s;
        }

        public ByteString getNameBytes() {
            Object ref = this.name_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.name_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasUrl() {
            return (this.bitField0_ & 0x4) == 4;
        }

        public String getUrl() {
            Object ref = this.url_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.url_ = s;
            }
            return s;
        }

        public ByteString getUrlBytes() {
            Object ref = this.url_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.url_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasKeyword() {
            return (this.bitField0_ & 0x8) == 8;
        }

        public String getKeyword() {
            Object ref = this.keyword_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.keyword_ = s;
            }
            return s;
        }

        public ByteString getKeywordBytes() {
            Object ref = this.keyword_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.keyword_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.type_ = 0;
            this.name_ = "";
            this.url_ = "";
            this.keyword_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasType()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasUrl()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasKeyword()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.type_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getUrlBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeBytes(4, getKeywordBytes());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeInt32Size(1, this.type_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size = size + CodedOutputStream.computeBytesSize(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size = size + CodedOutputStream.computeBytesSize(3, getUrlBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size = size + CodedOutputStream.computeBytesSize(4, getKeywordBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Referer parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Referer) PARSER.parseFrom(data);
        }

        public static Referer parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Referer) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Referer parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Referer) PARSER.parseFrom(data);
        }

        public static Referer parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Referer) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Referer parseFrom(InputStream input) throws IOException {
            return (Referer) PARSER.parseFrom(input);
        }

        public static Referer parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Referer) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Referer parseDelimitedFrom(InputStream input) throws IOException {
            return (Referer) PARSER.parseDelimitedFrom(input);
        }

        public static Referer parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Referer) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Referer parseFrom(CodedInputStream input) throws IOException {
            return (Referer) PARSER.parseFrom(input);
        }

        public static Referer parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Referer) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Referer prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.RefererOrBuilder {
            private int bitField0_;
            private int type_;
            private Object name_ = "";

            private Object url_ = "";

            private Object keyword_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_Referer_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_Referer_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.Referer.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                WebMsgProto.Referer.newBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.type_ = 0;
                this.bitField0_ &= -2;
                this.name_ = "";
                this.bitField0_ &= -3;
                this.url_ = "";
                this.bitField0_ &= -5;
                this.keyword_ = "";
                this.bitField0_ &= -9;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_Referer_descriptor;
            }

            public WebMsgProto.Referer getDefaultInstanceForType() {
                return WebMsgProto.Referer.getDefaultInstance();
            }

            public WebMsgProto.Referer build() {
                WebMsgProto.Referer result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.Referer buildPartial() {
                WebMsgProto.Referer result = new WebMsgProto.Referer(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.type_ = this.type_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.url_ = this.url_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.keyword_ = this.keyword_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.Referer)) {
                    return mergeFrom((WebMsgProto.Referer) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.Referer other) {
                if (other == WebMsgProto.Referer.getDefaultInstance())
                    return this;
                if (other.hasType()) {
                    setType(other.getType());
                }
                if (other.hasName()) {
                    this.bitField0_ |= 2;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasUrl()) {
                    this.bitField0_ |= 4;
                    this.url_ = other.url_;
                    onChanged();
                }
                if (other.hasKeyword()) {
                    this.bitField0_ |= 8;
                    this.keyword_ = other.keyword_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasType()) {
                    return false;
                }
                if (!hasName()) {
                    return false;
                }
                if (!hasUrl()) {
                    return false;
                }
                if (!hasKeyword()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.Referer parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.Referer) WebMsgProto.Referer.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.Referer) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasType() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.bitField0_ |= 1;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= -2;
                this.type_ = 0;
                onChanged();
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 0x2) == 2;
            }

            public String getName() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.name_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getNameBytes() {
                Object ref = this.name_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.name_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -3;
                this.name_ = WebMsgProto.Referer.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.name_ = value;
                onChanged();
                return this;
            }

            public boolean hasUrl() {
                return (this.bitField0_ & 0x4) == 4;
            }

            public String getUrl() {
                Object ref = this.url_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.url_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getUrlBytes() {
                Object ref = this.url_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.url_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.url_ = value;
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.bitField0_ &= -5;
                this.url_ = WebMsgProto.Referer.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            public Builder setUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.url_ = value;
                onChanged();
                return this;
            }

            public boolean hasKeyword() {
                return (this.bitField0_ & 0x8) == 8;
            }

            public String getKeyword() {
                Object ref = this.keyword_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.keyword_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getKeywordBytes() {
                Object ref = this.keyword_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.keyword_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setKeyword(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.keyword_ = value;
                onChanged();
                return this;
            }

            public Builder clearKeyword() {
                this.bitField0_ &= -9;
                this.keyword_ = WebMsgProto.Referer.getDefaultInstance().getKeyword();
                onChanged();
                return this;
            }

            public Builder setKeywordBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.keyword_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static abstract interface RefererOrBuilder extends MessageOrBuilder {
        public abstract boolean hasType();

        public abstract int getType();

        public abstract boolean hasName();

        public abstract String getName();

        public abstract ByteString getNameBytes();

        public abstract boolean hasUrl();

        public abstract String getUrl();

        public abstract ByteString getUrlBytes();

        public abstract boolean hasKeyword();

        public abstract String getKeyword();

        public abstract ByteString getKeywordBytes();
    }

    public static final class SiteItem extends GeneratedMessage implements WebMsgProto.SiteItemOrBuilder {
        private static final SiteItem defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<SiteItem> PARSER = new AbstractParser() {
            public WebMsgProto.SiteItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.SiteItem(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int IDSITE_FIELD_NUMBER = 1;
        private int idsite_;
        public static final int NAME_FIELD_NUMBER = 2;
        private Object name_;
        public static final int MAIN_URL_FIELD_NUMBER = 3;
        private Object mainUrl_;
        public static final int TS_CREATED_FIELD_NUMBER = 4;
        private long tsCreated_;
        public static final int ECOMMERCE_FIELD_NUMBER = 5;
        private int ecommerce_;
        public static final int TIMEZONE_FIELD_NUMBER = 6;
        private Object timezone_;
        public static final int CURRENCY_FIELD_NUMBER = 7;
        private Object currency_;
        public static final int EXCLUDED_IPS_FIELD_NUMBER = 8;
        private Object excludedIps_;
        public static final int EXCLUDED_PARAMETERS_FIELD_NUMBER = 9;
        private Object excludedParameters_;
        public static final int EXCLUDED_USER_AGENTS_FIELD_NUMBER = 10;
        private Object excludedUserAgents_;
        public static final int SITESEARCH_FIELD_NUMBER = 11;
        private int sitesearch_;
        public static final int SITESEARCH_KEYWORD_PARAMETERS_FIELD_NUMBER = 12;
        private Object sitesearchKeywordParameters_;
        public static final int SITESEARCH_CATEGORY_PARAMETERS_FIELD_NUMBER = 13;
        private Object sitesearchCategoryParameters_;
        public static final int GROUP_FIELD_NUMBER = 14;
        private Object group_;
        public static final int KEEP_URL_FRAGMENT_FIELD_NUMBER = 15;
        private int keepUrlFragment_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new SiteItem(true);
            defaultInstance.initFields();
        }

        private SiteItem(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private SiteItem(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SiteItem getDefaultInstance() {
            return defaultInstance;
        }

        public SiteItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SiteItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.idsite_ = input.readInt32();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.name_ = input.readBytes();
                            break;
                        case 26:
                            this.bitField0_ |= 4;
                            this.mainUrl_ = input.readBytes();
                            break;
                        case 32:
                            this.bitField0_ |= 8;
                            this.tsCreated_ = input.readInt64();
                            break;
                        case 40:
                            this.bitField0_ |= 16;
                            this.ecommerce_ = input.readInt32();
                            break;
                        case 50:
                            this.bitField0_ |= 32;
                            this.timezone_ = input.readBytes();
                            break;
                        case 58:
                            this.bitField0_ |= 64;
                            this.currency_ = input.readBytes();
                            break;
                        case 66:
                            this.bitField0_ |= 128;
                            this.excludedIps_ = input.readBytes();
                            break;
                        case 74:
                            this.bitField0_ |= 256;
                            this.excludedParameters_ = input.readBytes();
                            break;
                        case 82:
                            this.bitField0_ |= 512;
                            this.excludedUserAgents_ = input.readBytes();
                            break;
                        case 88:
                            this.bitField0_ |= 1024;
                            this.sitesearch_ = input.readInt32();
                            break;
                        case 98:
                            this.bitField0_ |= 2048;
                            this.sitesearchKeywordParameters_ = input.readBytes();
                            break;
                        case 106:
                            this.bitField0_ |= 4096;
                            this.sitesearchCategoryParameters_ = input.readBytes();
                            break;
                        case 114:
                            this.bitField0_ |= 8192;
                            this.group_ = input.readBytes();
                            break;
                        case 120:
                            this.bitField0_ |= 16384;
                            this.keepUrlFragment_ = input.readInt32();
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_SiteItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_SiteItem_fieldAccessorTable.ensureFieldAccessorsInitialized(SiteItem.class, Builder.class);
        }

        public Parser<SiteItem> getParserForType() {
            return PARSER;
        }

        public boolean hasIdsite() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public int getIdsite() {
            return this.idsite_;
        }

        public boolean hasName() {
            return (this.bitField0_ & 0x2) == 2;
        }

        public String getName() {
            Object ref = this.name_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.name_ = s;
            }
            return s;
        }

        public ByteString getNameBytes() {
            Object ref = this.name_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.name_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasMainUrl() {
            return (this.bitField0_ & 0x4) == 4;
        }

        public String getMainUrl() {
            Object ref = this.mainUrl_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.mainUrl_ = s;
            }
            return s;
        }

        public ByteString getMainUrlBytes() {
            Object ref = this.mainUrl_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.mainUrl_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasTsCreated() {
            return (this.bitField0_ & 0x8) == 8;
        }

        public long getTsCreated() {
            return this.tsCreated_;
        }

        public boolean hasEcommerce() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public int getEcommerce() {
            return this.ecommerce_;
        }

        public boolean hasTimezone() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public String getTimezone() {
            Object ref = this.timezone_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.timezone_ = s;
            }
            return s;
        }

        public ByteString getTimezoneBytes() {
            Object ref = this.timezone_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.timezone_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasCurrency() {
            return (this.bitField0_ & 0x40) == 64;
        }

        public String getCurrency() {
            Object ref = this.currency_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.currency_ = s;
            }
            return s;
        }

        public ByteString getCurrencyBytes() {
            Object ref = this.currency_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.currency_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasExcludedIps() {
            return (this.bitField0_ & 0x80) == 128;
        }

        public String getExcludedIps() {
            Object ref = this.excludedIps_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.excludedIps_ = s;
            }
            return s;
        }

        public ByteString getExcludedIpsBytes() {
            Object ref = this.excludedIps_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.excludedIps_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasExcludedParameters() {
            return (this.bitField0_ & 0x100) == 256;
        }

        public String getExcludedParameters() {
            Object ref = this.excludedParameters_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.excludedParameters_ = s;
            }
            return s;
        }

        public ByteString getExcludedParametersBytes() {
            Object ref = this.excludedParameters_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.excludedParameters_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasExcludedUserAgents() {
            return (this.bitField0_ & 0x200) == 512;
        }

        public String getExcludedUserAgents() {
            Object ref = this.excludedUserAgents_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.excludedUserAgents_ = s;
            }
            return s;
        }

        public ByteString getExcludedUserAgentsBytes() {
            Object ref = this.excludedUserAgents_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.excludedUserAgents_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasSitesearch() {
            return (this.bitField0_ & 0x400) == 1024;
        }

        public int getSitesearch() {
            return this.sitesearch_;
        }

        public boolean hasSitesearchKeywordParameters() {
            return (this.bitField0_ & 0x800) == 2048;
        }

        public String getSitesearchKeywordParameters() {
            Object ref = this.sitesearchKeywordParameters_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.sitesearchKeywordParameters_ = s;
            }
            return s;
        }

        public ByteString getSitesearchKeywordParametersBytes() {
            Object ref = this.sitesearchKeywordParameters_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.sitesearchKeywordParameters_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasSitesearchCategoryParameters() {
            return (this.bitField0_ & 0x1000) == 4096;
        }

        public String getSitesearchCategoryParameters() {
            Object ref = this.sitesearchCategoryParameters_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.sitesearchCategoryParameters_ = s;
            }
            return s;
        }

        public ByteString getSitesearchCategoryParametersBytes() {
            Object ref = this.sitesearchCategoryParameters_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.sitesearchCategoryParameters_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasGroup() {
            return (this.bitField0_ & 0x2000) == 8192;
        }

        public String getGroup() {
            Object ref = this.group_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.group_ = s;
            }
            return s;
        }

        public ByteString getGroupBytes() {
            Object ref = this.group_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.group_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        public boolean hasKeepUrlFragment() {
            return (this.bitField0_ & 0x4000) == 16384;
        }

        public int getKeepUrlFragment() {
            return this.keepUrlFragment_;
        }

        private void initFields() {
            this.idsite_ = 0;
            this.name_ = "";
            this.mainUrl_ = "";
            this.tsCreated_ = 0L;
            this.ecommerce_ = 0;
            this.timezone_ = "";
            this.currency_ = "";
            this.excludedIps_ = "";
            this.excludedParameters_ = "";
            this.excludedUserAgents_ = "";
            this.sitesearch_ = 1;
            this.sitesearchKeywordParameters_ = "";
            this.sitesearchCategoryParameters_ = "";
            this.group_ = "";
            this.keepUrlFragment_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasIdsite()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasMainUrl()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTsCreated()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasEcommerce()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTimezone()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCurrency()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasExcludedIps()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasExcludedParameters()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasExcludedUserAgents()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasSitesearch()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasSitesearchKeywordParameters()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasSitesearchCategoryParameters()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasGroup()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasKeepUrlFragment()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.idsite_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeBytes(3, getMainUrlBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt64(4, this.tsCreated_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.ecommerce_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeBytes(6, getTimezoneBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeBytes(7, getCurrencyBytes());
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeBytes(8, getExcludedIpsBytes());
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeBytes(9, getExcludedParametersBytes());
            }
            if ((this.bitField0_ & 0x200) == 512) {
                output.writeBytes(10, getExcludedUserAgentsBytes());
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                output.writeInt32(11, this.sitesearch_);
            }
            if ((this.bitField0_ & 0x800) == 2048) {
                output.writeBytes(12, getSitesearchKeywordParametersBytes());
            }
            if ((this.bitField0_ & 0x1000) == 4096) {
                output.writeBytes(13, getSitesearchCategoryParametersBytes());
            }
            if ((this.bitField0_ & 0x2000) == 8192) {
                output.writeBytes(14, getGroupBytes());
            }
            if ((this.bitField0_ & 0x4000) == 16384) {
                output.writeInt32(15, this.keepUrlFragment_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeInt32Size(1, this.idsite_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size = size + CodedOutputStream.computeBytesSize(2, getNameBytes());
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size = size + CodedOutputStream.computeBytesSize(3, getMainUrlBytes());
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size = size + CodedOutputStream.computeInt64Size(4, this.tsCreated_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size = size + CodedOutputStream.computeInt32Size(5, this.ecommerce_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size = size + CodedOutputStream.computeBytesSize(6, getTimezoneBytes());
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size = size + CodedOutputStream.computeBytesSize(7, getCurrencyBytes());
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size = size + CodedOutputStream.computeBytesSize(8, getExcludedIpsBytes());
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size = size + CodedOutputStream.computeBytesSize(9, getExcludedParametersBytes());
            }
            if ((this.bitField0_ & 0x200) == 512) {
                size = size + CodedOutputStream.computeBytesSize(10, getExcludedUserAgentsBytes());
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                size = size + CodedOutputStream.computeInt32Size(11, this.sitesearch_);
            }
            if ((this.bitField0_ & 0x800) == 2048) {
                size = size + CodedOutputStream.computeBytesSize(12, getSitesearchKeywordParametersBytes());
            }
            if ((this.bitField0_ & 0x1000) == 4096) {
                size = size + CodedOutputStream.computeBytesSize(13, getSitesearchCategoryParametersBytes());
            }
            if ((this.bitField0_ & 0x2000) == 8192) {
                size = size + CodedOutputStream.computeBytesSize(14, getGroupBytes());
            }
            if ((this.bitField0_ & 0x4000) == 16384) {
                size = size + CodedOutputStream.computeInt32Size(15, this.keepUrlFragment_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SiteItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SiteItem) PARSER.parseFrom(data);
        }

        public static SiteItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SiteItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SiteItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SiteItem) PARSER.parseFrom(data);
        }

        public static SiteItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SiteItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SiteItem parseFrom(InputStream input) throws IOException {
            return (SiteItem) PARSER.parseFrom(input);
        }

        public static SiteItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SiteItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SiteItem parseDelimitedFrom(InputStream input) throws IOException {
            return (SiteItem) PARSER.parseDelimitedFrom(input);
        }

        public static SiteItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SiteItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SiteItem parseFrom(CodedInputStream input) throws IOException {
            return (SiteItem) PARSER.parseFrom(input);
        }

        public static SiteItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SiteItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SiteItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.SiteItemOrBuilder {
            private int bitField0_;
            private int idsite_;
            private Object name_ = "";

            private Object mainUrl_ = "";
            private long tsCreated_;
            private int ecommerce_;
            private Object timezone_ = "";

            private Object currency_ = "";

            private Object excludedIps_ = "";

            private Object excludedParameters_ = "";

            private Object excludedUserAgents_ = "";

            private int sitesearch_ = 1;

            private Object sitesearchKeywordParameters_ = "";

            private Object sitesearchCategoryParameters_ = "";

            private Object group_ = "";
            private int keepUrlFragment_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_SiteItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_SiteItem_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.SiteItem.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                WebMsgProto.SiteItem.newBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.idsite_ = 0;
                this.bitField0_ &= -2;
                this.name_ = "";
                this.bitField0_ &= -3;
                this.mainUrl_ = "";
                this.bitField0_ &= -5;
                this.tsCreated_ = 0L;
                this.bitField0_ &= -9;
                this.ecommerce_ = 0;
                this.bitField0_ &= -17;
                this.timezone_ = "";
                this.bitField0_ &= -33;
                this.currency_ = "";
                this.bitField0_ &= -65;
                this.excludedIps_ = "";
                this.bitField0_ &= -129;
                this.excludedParameters_ = "";
                this.bitField0_ &= -257;
                this.excludedUserAgents_ = "";
                this.bitField0_ &= -513;
                this.sitesearch_ = 1;
                this.bitField0_ &= -1025;
                this.sitesearchKeywordParameters_ = "";
                this.bitField0_ &= -2049;
                this.sitesearchCategoryParameters_ = "";
                this.bitField0_ &= -4097;
                this.group_ = "";
                this.bitField0_ &= -8193;
                this.keepUrlFragment_ = 0;
                this.bitField0_ &= -16385;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_SiteItem_descriptor;
            }

            public WebMsgProto.SiteItem getDefaultInstanceForType() {
                return WebMsgProto.SiteItem.getDefaultInstance();
            }

            public WebMsgProto.SiteItem build() {
                WebMsgProto.SiteItem result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.SiteItem buildPartial() {
                WebMsgProto.SiteItem result = new WebMsgProto.SiteItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.idsite_ = this.idsite_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.mainUrl_ = this.mainUrl_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.tsCreated_ = this.tsCreated_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 16;
                }
                result.ecommerce_ = this.ecommerce_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 32;
                }
                result.timezone_ = this.timezone_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 64;
                }
                result.currency_ = this.currency_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 128;
                }
                result.excludedIps_ = this.excludedIps_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 256;
                }
                result.excludedParameters_ = this.excludedParameters_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 512;
                }
                result.excludedUserAgents_ = this.excludedUserAgents_;
                if ((from_bitField0_ & 0x400) == 1024) {
                    to_bitField0_ |= 1024;
                }
                result.sitesearch_ = this.sitesearch_;
                if ((from_bitField0_ & 0x800) == 2048) {
                    to_bitField0_ |= 2048;
                }
                result.sitesearchKeywordParameters_ = this.sitesearchKeywordParameters_;
                if ((from_bitField0_ & 0x1000) == 4096) {
                    to_bitField0_ |= 4096;
                }
                result.sitesearchCategoryParameters_ = this.sitesearchCategoryParameters_;
                if ((from_bitField0_ & 0x2000) == 8192) {
                    to_bitField0_ |= 8192;
                }
                result.group_ = this.group_;
                if ((from_bitField0_ & 0x4000) == 16384) {
                    to_bitField0_ |= 16384;
                }
                result.keepUrlFragment_ = this.keepUrlFragment_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.SiteItem)) {
                    return mergeFrom((WebMsgProto.SiteItem) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.SiteItem other) {
                if (other == WebMsgProto.SiteItem.getDefaultInstance())
                    return this;
                if (other.hasIdsite()) {
                    setIdsite(other.getIdsite());
                }
                if (other.hasName()) {
                    this.bitField0_ |= 2;
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasMainUrl()) {
                    this.bitField0_ |= 4;
                    this.mainUrl_ = other.mainUrl_;
                    onChanged();
                }
                if (other.hasTsCreated()) {
                    setTsCreated(other.getTsCreated());
                }
                if (other.hasEcommerce()) {
                    setEcommerce(other.getEcommerce());
                }
                if (other.hasTimezone()) {
                    this.bitField0_ |= 32;
                    this.timezone_ = other.timezone_;
                    onChanged();
                }
                if (other.hasCurrency()) {
                    this.bitField0_ |= 64;
                    this.currency_ = other.currency_;
                    onChanged();
                }
                if (other.hasExcludedIps()) {
                    this.bitField0_ |= 128;
                    this.excludedIps_ = other.excludedIps_;
                    onChanged();
                }
                if (other.hasExcludedParameters()) {
                    this.bitField0_ |= 256;
                    this.excludedParameters_ = other.excludedParameters_;
                    onChanged();
                }
                if (other.hasExcludedUserAgents()) {
                    this.bitField0_ |= 512;
                    this.excludedUserAgents_ = other.excludedUserAgents_;
                    onChanged();
                }
                if (other.hasSitesearch()) {
                    setSitesearch(other.getSitesearch());
                }
                if (other.hasSitesearchKeywordParameters()) {
                    this.bitField0_ |= 2048;
                    this.sitesearchKeywordParameters_ = other.sitesearchKeywordParameters_;
                    onChanged();
                }
                if (other.hasSitesearchCategoryParameters()) {
                    this.bitField0_ |= 4096;
                    this.sitesearchCategoryParameters_ = other.sitesearchCategoryParameters_;
                    onChanged();
                }
                if (other.hasGroup()) {
                    this.bitField0_ |= 8192;
                    this.group_ = other.group_;
                    onChanged();
                }
                if (other.hasKeepUrlFragment()) {
                    setKeepUrlFragment(other.getKeepUrlFragment());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasIdsite()) {
                    return false;
                }
                if (!hasName()) {
                    return false;
                }
                if (!hasMainUrl()) {
                    return false;
                }
                if (!hasTsCreated()) {
                    return false;
                }
                if (!hasEcommerce()) {
                    return false;
                }
                if (!hasTimezone()) {
                    return false;
                }
                if (!hasCurrency()) {
                    return false;
                }
                if (!hasExcludedIps()) {
                    return false;
                }
                if (!hasExcludedParameters()) {
                    return false;
                }
                if (!hasExcludedUserAgents()) {
                    return false;
                }
                if (!hasSitesearch()) {
                    return false;
                }
                if (!hasSitesearchKeywordParameters()) {
                    return false;
                }
                if (!hasSitesearchCategoryParameters()) {
                    return false;
                }
                if (!hasGroup()) {
                    return false;
                }
                if (!hasKeepUrlFragment()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.SiteItem parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.SiteItem) WebMsgProto.SiteItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.SiteItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasIdsite() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public int getIdsite() {
                return this.idsite_;
            }

            public Builder setIdsite(int value) {
                this.bitField0_ |= 1;
                this.idsite_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdsite() {
                this.bitField0_ &= -2;
                this.idsite_ = 0;
                onChanged();
                return this;
            }

            public boolean hasName() {
                return (this.bitField0_ & 0x2) == 2;
            }

            public String getName() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.name_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getNameBytes() {
                Object ref = this.name_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.name_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -3;
                this.name_ = WebMsgProto.SiteItem.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.name_ = value;
                onChanged();
                return this;
            }

            public boolean hasMainUrl() {
                return (this.bitField0_ & 0x4) == 4;
            }

            public String getMainUrl() {
                Object ref = this.mainUrl_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.mainUrl_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getMainUrlBytes() {
                Object ref = this.mainUrl_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.mainUrl_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setMainUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.mainUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearMainUrl() {
                this.bitField0_ &= -5;
                this.mainUrl_ = WebMsgProto.SiteItem.getDefaultInstance().getMainUrl();
                onChanged();
                return this;
            }

            public Builder setMainUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.mainUrl_ = value;
                onChanged();
                return this;
            }

            public boolean hasTsCreated() {
                return (this.bitField0_ & 0x8) == 8;
            }

            public long getTsCreated() {
                return this.tsCreated_;
            }

            public Builder setTsCreated(long value) {
                this.bitField0_ |= 8;
                this.tsCreated_ = value;
                onChanged();
                return this;
            }

            public Builder clearTsCreated() {
                this.bitField0_ &= -9;
                this.tsCreated_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasEcommerce() {
                return (this.bitField0_ & 0x10) == 16;
            }

            public int getEcommerce() {
                return this.ecommerce_;
            }

            public Builder setEcommerce(int value) {
                this.bitField0_ |= 16;
                this.ecommerce_ = value;
                onChanged();
                return this;
            }

            public Builder clearEcommerce() {
                this.bitField0_ &= -17;
                this.ecommerce_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTimezone() {
                return (this.bitField0_ & 0x20) == 32;
            }

            public String getTimezone() {
                Object ref = this.timezone_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.timezone_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getTimezoneBytes() {
                Object ref = this.timezone_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.timezone_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setTimezone(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 32;
                this.timezone_ = value;
                onChanged();
                return this;
            }

            public Builder clearTimezone() {
                this.bitField0_ &= -33;
                this.timezone_ = WebMsgProto.SiteItem.getDefaultInstance().getTimezone();
                onChanged();
                return this;
            }

            public Builder setTimezoneBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 32;
                this.timezone_ = value;
                onChanged();
                return this;
            }

            public boolean hasCurrency() {
                return (this.bitField0_ & 0x40) == 64;
            }

            public String getCurrency() {
                Object ref = this.currency_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.currency_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getCurrencyBytes() {
                Object ref = this.currency_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.currency_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setCurrency(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.currency_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurrency() {
                this.bitField0_ &= -65;
                this.currency_ = WebMsgProto.SiteItem.getDefaultInstance().getCurrency();
                onChanged();
                return this;
            }

            public Builder setCurrencyBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.currency_ = value;
                onChanged();
                return this;
            }

            public boolean hasExcludedIps() {
                return (this.bitField0_ & 0x80) == 128;
            }

            public String getExcludedIps() {
                Object ref = this.excludedIps_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.excludedIps_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getExcludedIpsBytes() {
                Object ref = this.excludedIps_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.excludedIps_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setExcludedIps(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 128;
                this.excludedIps_ = value;
                onChanged();
                return this;
            }

            public Builder clearExcludedIps() {
                this.bitField0_ &= -129;
                this.excludedIps_ = WebMsgProto.SiteItem.getDefaultInstance().getExcludedIps();
                onChanged();
                return this;
            }

            public Builder setExcludedIpsBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 128;
                this.excludedIps_ = value;
                onChanged();
                return this;
            }

            public boolean hasExcludedParameters() {
                return (this.bitField0_ & 0x100) == 256;
            }

            public String getExcludedParameters() {
                Object ref = this.excludedParameters_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.excludedParameters_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getExcludedParametersBytes() {
                Object ref = this.excludedParameters_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.excludedParameters_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setExcludedParameters(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 256;
                this.excludedParameters_ = value;
                onChanged();
                return this;
            }

            public Builder clearExcludedParameters() {
                this.bitField0_ &= -257;
                this.excludedParameters_ = WebMsgProto.SiteItem.getDefaultInstance().getExcludedParameters();
                onChanged();
                return this;
            }

            public Builder setExcludedParametersBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 256;
                this.excludedParameters_ = value;
                onChanged();
                return this;
            }

            public boolean hasExcludedUserAgents() {
                return (this.bitField0_ & 0x200) == 512;
            }

            public String getExcludedUserAgents() {
                Object ref = this.excludedUserAgents_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.excludedUserAgents_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getExcludedUserAgentsBytes() {
                Object ref = this.excludedUserAgents_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.excludedUserAgents_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setExcludedUserAgents(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 512;
                this.excludedUserAgents_ = value;
                onChanged();
                return this;
            }

            public Builder clearExcludedUserAgents() {
                this.bitField0_ &= -513;
                this.excludedUserAgents_ = WebMsgProto.SiteItem.getDefaultInstance().getExcludedUserAgents();
                onChanged();
                return this;
            }

            public Builder setExcludedUserAgentsBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 512;
                this.excludedUserAgents_ = value;
                onChanged();
                return this;
            }

            public boolean hasSitesearch() {
                return (this.bitField0_ & 0x400) == 1024;
            }

            public int getSitesearch() {
                return this.sitesearch_;
            }

            public Builder setSitesearch(int value) {
                this.bitField0_ |= 1024;
                this.sitesearch_ = value;
                onChanged();
                return this;
            }

            public Builder clearSitesearch() {
                this.bitField0_ &= -1025;
                this.sitesearch_ = 1;
                onChanged();
                return this;
            }

            public boolean hasSitesearchKeywordParameters() {
                return (this.bitField0_ & 0x800) == 2048;
            }

            public String getSitesearchKeywordParameters() {
                Object ref = this.sitesearchKeywordParameters_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.sitesearchKeywordParameters_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getSitesearchKeywordParametersBytes() {
                Object ref = this.sitesearchKeywordParameters_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.sitesearchKeywordParameters_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setSitesearchKeywordParameters(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2048;
                this.sitesearchKeywordParameters_ = value;
                onChanged();
                return this;
            }

            public Builder clearSitesearchKeywordParameters() {
                this.bitField0_ &= -2049;
                this.sitesearchKeywordParameters_ = WebMsgProto.SiteItem.getDefaultInstance().getSitesearchKeywordParameters();
                onChanged();
                return this;
            }

            public Builder setSitesearchKeywordParametersBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2048;
                this.sitesearchKeywordParameters_ = value;
                onChanged();
                return this;
            }

            public boolean hasSitesearchCategoryParameters() {
                return (this.bitField0_ & 0x1000) == 4096;
            }

            public String getSitesearchCategoryParameters() {
                Object ref = this.sitesearchCategoryParameters_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.sitesearchCategoryParameters_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getSitesearchCategoryParametersBytes() {
                Object ref = this.sitesearchCategoryParameters_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.sitesearchCategoryParameters_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setSitesearchCategoryParameters(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4096;
                this.sitesearchCategoryParameters_ = value;
                onChanged();
                return this;
            }

            public Builder clearSitesearchCategoryParameters() {
                this.bitField0_ &= -4097;
                this.sitesearchCategoryParameters_ = WebMsgProto.SiteItem.getDefaultInstance().getSitesearchCategoryParameters();
                onChanged();
                return this;
            }

            public Builder setSitesearchCategoryParametersBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4096;
                this.sitesearchCategoryParameters_ = value;
                onChanged();
                return this;
            }

            public boolean hasGroup() {
                return (this.bitField0_ & 0x2000) == 8192;
            }

            public String getGroup() {
                Object ref = this.group_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.group_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getGroupBytes() {
                Object ref = this.group_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.group_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setGroup(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8192;
                this.group_ = value;
                onChanged();
                return this;
            }

            public Builder clearGroup() {
                this.bitField0_ &= -8193;
                this.group_ = WebMsgProto.SiteItem.getDefaultInstance().getGroup();
                onChanged();
                return this;
            }

            public Builder setGroupBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8192;
                this.group_ = value;
                onChanged();
                return this;
            }

            public boolean hasKeepUrlFragment() {
                return (this.bitField0_ & 0x4000) == 16384;
            }

            public int getKeepUrlFragment() {
                return this.keepUrlFragment_;
            }

            public Builder setKeepUrlFragment(int value) {
                this.bitField0_ |= 16384;
                this.keepUrlFragment_ = value;
                onChanged();
                return this;
            }

            public Builder clearKeepUrlFragment() {
                this.bitField0_ &= -16385;
                this.keepUrlFragment_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static abstract interface SiteItemOrBuilder extends MessageOrBuilder {
        public abstract boolean hasIdsite();

        public abstract int getIdsite();

        public abstract boolean hasName();

        public abstract String getName();

        public abstract ByteString getNameBytes();

        public abstract boolean hasMainUrl();

        public abstract String getMainUrl();

        public abstract ByteString getMainUrlBytes();

        public abstract boolean hasTsCreated();

        public abstract long getTsCreated();

        public abstract boolean hasEcommerce();

        public abstract int getEcommerce();

        public abstract boolean hasTimezone();

        public abstract String getTimezone();

        public abstract ByteString getTimezoneBytes();

        public abstract boolean hasCurrency();

        public abstract String getCurrency();

        public abstract ByteString getCurrencyBytes();

        public abstract boolean hasExcludedIps();

        public abstract String getExcludedIps();

        public abstract ByteString getExcludedIpsBytes();

        public abstract boolean hasExcludedParameters();

        public abstract String getExcludedParameters();

        public abstract ByteString getExcludedParametersBytes();

        public abstract boolean hasExcludedUserAgents();

        public abstract String getExcludedUserAgents();

        public abstract ByteString getExcludedUserAgentsBytes();

        public abstract boolean hasSitesearch();

        public abstract int getSitesearch();

        public abstract boolean hasSitesearchKeywordParameters();

        public abstract String getSitesearchKeywordParameters();

        public abstract ByteString getSitesearchKeywordParametersBytes();

        public abstract boolean hasSitesearchCategoryParameters();

        public abstract String getSitesearchCategoryParameters();

        public abstract ByteString getSitesearchCategoryParametersBytes();

        public abstract boolean hasGroup();

        public abstract String getGroup();

        public abstract ByteString getGroupBytes();

        public abstract boolean hasKeepUrlFragment();

        public abstract int getKeepUrlFragment();
    }

    public static final class SiteUrlItem extends GeneratedMessage implements WebMsgProto.SiteUrlItemOrBuilder {
        private static final SiteUrlItem defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<SiteUrlItem> PARSER = new AbstractParser() {
            public WebMsgProto.SiteUrlItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.SiteUrlItem(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int TS_UPDATED_FIELD_NUMBER = 1;
        private long tsUpdated_;
        public static final int SITEURL_FIELD_NUMBER = 2;
        private List<WebMsgProto.SiteUrlRecord> siteurl_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new SiteUrlItem(true);
            defaultInstance.initFields();
        }

        private SiteUrlItem(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private SiteUrlItem(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SiteUrlItem getDefaultInstance() {
            return defaultInstance;
        }

        public SiteUrlItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SiteUrlItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.tsUpdated_ = input.readInt64();
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.siteurl_ = new ArrayList();
                                mutable_bitField0_ |= 2;
                            }
                            this.siteurl_.add((WebMsgProto.SiteUrlRecord) input.readMessage(WebMsgProto.SiteUrlRecord.PARSER, extensionRegistry));
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) {
                    this.siteurl_ = Collections.unmodifiableList(this.siteurl_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_SiteUrlItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_SiteUrlItem_fieldAccessorTable.ensureFieldAccessorsInitialized(SiteUrlItem.class, Builder.class);
        }

        public Parser<SiteUrlItem> getParserForType() {
            return PARSER;
        }

        public boolean hasTsUpdated() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public long getTsUpdated() {
            return this.tsUpdated_;
        }

        public List<WebMsgProto.SiteUrlRecord> getSiteurlList() {
            return this.siteurl_;
        }

        public List<? extends WebMsgProto.SiteUrlRecordOrBuilder> getSiteurlOrBuilderList() {
            return this.siteurl_;
        }

        public int getSiteurlCount() {
            return this.siteurl_.size();
        }

        public WebMsgProto.SiteUrlRecord getSiteurl(int index) {
            return (WebMsgProto.SiteUrlRecord) this.siteurl_.get(index);
        }

        public WebMsgProto.SiteUrlRecordOrBuilder getSiteurlOrBuilder(int index) {
            return (WebMsgProto.SiteUrlRecordOrBuilder) this.siteurl_.get(index);
        }

        private void initFields() {
            this.tsUpdated_ = 0L;
            this.siteurl_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasTsUpdated()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getSiteurlCount(); i++) {
                if (!getSiteurl(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt64(1, this.tsUpdated_);
            }
            for (int i = 0; i < this.siteurl_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.siteurl_.get(i));
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeInt64Size(1, this.tsUpdated_);
            }
            for (int i = 0; i < this.siteurl_.size(); i++) {
                size = size + CodedOutputStream.computeMessageSize(2, (MessageLite) this.siteurl_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SiteUrlItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SiteUrlItem) PARSER.parseFrom(data);
        }

        public static SiteUrlItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SiteUrlItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SiteUrlItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SiteUrlItem) PARSER.parseFrom(data);
        }

        public static SiteUrlItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SiteUrlItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SiteUrlItem parseFrom(InputStream input) throws IOException {
            return (SiteUrlItem) PARSER.parseFrom(input);
        }

        public static SiteUrlItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SiteUrlItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SiteUrlItem parseDelimitedFrom(InputStream input) throws IOException {
            return (SiteUrlItem) PARSER.parseDelimitedFrom(input);
        }

        public static SiteUrlItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SiteUrlItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SiteUrlItem parseFrom(CodedInputStream input) throws IOException {
            return (SiteUrlItem) PARSER.parseFrom(input);
        }

        public static SiteUrlItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SiteUrlItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SiteUrlItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.SiteUrlItemOrBuilder {
            private int bitField0_;
            private long tsUpdated_;
            private List<WebMsgProto.SiteUrlRecord> siteurl_ = Collections.emptyList();
            private RepeatedFieldBuilder<WebMsgProto.SiteUrlRecord, WebMsgProto.SiteUrlRecord.Builder, WebMsgProto.SiteUrlRecordOrBuilder> siteurlBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_SiteUrlItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_SiteUrlItem_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.SiteUrlItem.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WebMsgProto.SiteUrlItem.alwaysUseFieldBuilders)
                    getSiteurlFieldBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.tsUpdated_ = 0L;
                this.bitField0_ &= -2;
                if (this.siteurlBuilder_ == null) {
                    this.siteurl_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.siteurlBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_SiteUrlItem_descriptor;
            }

            public WebMsgProto.SiteUrlItem getDefaultInstanceForType() {
                return WebMsgProto.SiteUrlItem.getDefaultInstance();
            }

            public WebMsgProto.SiteUrlItem build() {
                WebMsgProto.SiteUrlItem result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.SiteUrlItem buildPartial() {
                WebMsgProto.SiteUrlItem result = new WebMsgProto.SiteUrlItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.tsUpdated_ = this.tsUpdated_;
                if (this.siteurlBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.siteurl_ = Collections.unmodifiableList(this.siteurl_);
                        this.bitField0_ &= -3;
                    }
                    result.siteurl_ = this.siteurl_;
                } else {
                    result.siteurl_ = this.siteurlBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.SiteUrlItem)) {
                    return mergeFrom((WebMsgProto.SiteUrlItem) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.SiteUrlItem other) {
                if (other == WebMsgProto.SiteUrlItem.getDefaultInstance())
                    return this;
                if (other.hasTsUpdated()) {
                    setTsUpdated(other.getTsUpdated());
                }
                if (this.siteurlBuilder_ == null) {
                    if (!other.siteurl_.isEmpty()) {
                        if (this.siteurl_.isEmpty()) {
                            this.siteurl_ = other.siteurl_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureSiteurlIsMutable();
                            this.siteurl_.addAll(other.siteurl_);
                        }
                        onChanged();
                    }
                } else if (!other.siteurl_.isEmpty()) {
                    if (this.siteurlBuilder_.isEmpty()) {
                        this.siteurlBuilder_.dispose();
                        this.siteurlBuilder_ = null;
                        this.siteurl_ = other.siteurl_;
                        this.bitField0_ &= -3;
                        this.siteurlBuilder_ = (WebMsgProto.SiteUrlItem.alwaysUseFieldBuilders ? getSiteurlFieldBuilder() : null);
                    } else {
                        this.siteurlBuilder_.addAllMessages(other.siteurl_);
                    }
                }

                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasTsUpdated()) {
                    return false;
                }
                for (int i = 0; i < getSiteurlCount(); i++) {
                    if (!getSiteurl(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.SiteUrlItem parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.SiteUrlItem) WebMsgProto.SiteUrlItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.SiteUrlItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasTsUpdated() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public long getTsUpdated() {
                return this.tsUpdated_;
            }

            public Builder setTsUpdated(long value) {
                this.bitField0_ |= 1;
                this.tsUpdated_ = value;
                onChanged();
                return this;
            }

            public Builder clearTsUpdated() {
                this.bitField0_ &= -2;
                this.tsUpdated_ = 0L;
                onChanged();
                return this;
            }

            private void ensureSiteurlIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.siteurl_ = new ArrayList(this.siteurl_);
                    this.bitField0_ |= 2;
                }
            }

            public List<WebMsgProto.SiteUrlRecord> getSiteurlList() {
                if (this.siteurlBuilder_ == null) {
                    return Collections.unmodifiableList(this.siteurl_);
                }
                return this.siteurlBuilder_.getMessageList();
            }

            public int getSiteurlCount() {
                if (this.siteurlBuilder_ == null) {
                    return this.siteurl_.size();
                }
                return this.siteurlBuilder_.getCount();
            }

            public WebMsgProto.SiteUrlRecord getSiteurl(int index) {
                if (this.siteurlBuilder_ == null) {
                    return (WebMsgProto.SiteUrlRecord) this.siteurl_.get(index);
                }
                return (WebMsgProto.SiteUrlRecord) this.siteurlBuilder_.getMessage(index);
            }

            public Builder setSiteurl(int index, WebMsgProto.SiteUrlRecord value) {
                if (this.siteurlBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSiteurlIsMutable();
                    this.siteurl_.set(index, value);
                    onChanged();
                } else {
                    this.siteurlBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setSiteurl(int index, WebMsgProto.SiteUrlRecord.Builder builderForValue) {
                if (this.siteurlBuilder_ == null) {
                    ensureSiteurlIsMutable();
                    this.siteurl_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.siteurlBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSiteurl(WebMsgProto.SiteUrlRecord value) {
                if (this.siteurlBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSiteurlIsMutable();
                    this.siteurl_.add(value);
                    onChanged();
                } else {
                    this.siteurlBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addSiteurl(int index, WebMsgProto.SiteUrlRecord value) {
                if (this.siteurlBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureSiteurlIsMutable();
                    this.siteurl_.add(index, value);
                    onChanged();
                } else {
                    this.siteurlBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addSiteurl(WebMsgProto.SiteUrlRecord.Builder builderForValue) {
                if (this.siteurlBuilder_ == null) {
                    ensureSiteurlIsMutable();
                    this.siteurl_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.siteurlBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSiteurl(int index, WebMsgProto.SiteUrlRecord.Builder builderForValue) {
                if (this.siteurlBuilder_ == null) {
                    ensureSiteurlIsMutable();
                    this.siteurl_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.siteurlBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSiteurl(Iterable<? extends WebMsgProto.SiteUrlRecord> values) {
                if (this.siteurlBuilder_ == null) {
                    ensureSiteurlIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.siteurl_);
                    onChanged();
                } else {
                    this.siteurlBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSiteurl() {
                if (this.siteurlBuilder_ == null) {
                    this.siteurl_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.siteurlBuilder_.clear();
                }
                return this;
            }

            public Builder removeSiteurl(int index) {
                if (this.siteurlBuilder_ == null) {
                    ensureSiteurlIsMutable();
                    this.siteurl_.remove(index);
                    onChanged();
                } else {
                    this.siteurlBuilder_.remove(index);
                }
                return this;
            }

            public WebMsgProto.SiteUrlRecord.Builder getSiteurlBuilder(int index) {
                return (WebMsgProto.SiteUrlRecord.Builder) getSiteurlFieldBuilder().getBuilder(index);
            }

            public WebMsgProto.SiteUrlRecordOrBuilder getSiteurlOrBuilder(int index) {
                if (this.siteurlBuilder_ == null)
                    return (WebMsgProto.SiteUrlRecordOrBuilder) this.siteurl_.get(index);
                return (WebMsgProto.SiteUrlRecordOrBuilder) this.siteurlBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends WebMsgProto.SiteUrlRecordOrBuilder> getSiteurlOrBuilderList() {
                if (this.siteurlBuilder_ != null) {
                    return this.siteurlBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.siteurl_);
            }

            public WebMsgProto.SiteUrlRecord.Builder addSiteurlBuilder() {
                return (WebMsgProto.SiteUrlRecord.Builder) getSiteurlFieldBuilder().addBuilder(WebMsgProto.SiteUrlRecord.getDefaultInstance());
            }

            public WebMsgProto.SiteUrlRecord.Builder addSiteurlBuilder(int index) {
                return (WebMsgProto.SiteUrlRecord.Builder) getSiteurlFieldBuilder().addBuilder(index, WebMsgProto.SiteUrlRecord.getDefaultInstance());
            }

            public List<WebMsgProto.SiteUrlRecord.Builder> getSiteurlBuilderList() {
                return getSiteurlFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<WebMsgProto.SiteUrlRecord, WebMsgProto.SiteUrlRecord.Builder, WebMsgProto.SiteUrlRecordOrBuilder> getSiteurlFieldBuilder() {
                if (this.siteurlBuilder_ == null) {
                    this.siteurlBuilder_ = new RepeatedFieldBuilder(this.siteurl_, (this.bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
                    this.siteurl_ = null;
                }
                return this.siteurlBuilder_;
            }
        }
    }

    public static abstract interface SiteUrlItemOrBuilder extends MessageOrBuilder {
        public abstract boolean hasTsUpdated();

        public abstract long getTsUpdated();

        public abstract List<WebMsgProto.SiteUrlRecord> getSiteurlList();

        public abstract WebMsgProto.SiteUrlRecord getSiteurl(int paramInt);

        public abstract int getSiteurlCount();

        public abstract List<? extends WebMsgProto.SiteUrlRecordOrBuilder> getSiteurlOrBuilderList();

        public abstract WebMsgProto.SiteUrlRecordOrBuilder getSiteurlOrBuilder(int paramInt);
    }

    public static final class SiteUrlRecord extends GeneratedMessage implements WebMsgProto.SiteUrlRecordOrBuilder {
        private static final SiteUrlRecord defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<SiteUrlRecord> PARSER = new AbstractParser() {
            public WebMsgProto.SiteUrlRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.SiteUrlRecord(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int IDSITE_FIELD_NUMBER = 1;
        private int idsite_;
        public static final int URL_FIELD_NUMBER = 2;
        private Object url_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new SiteUrlRecord(true);
            defaultInstance.initFields();
        }

        private SiteUrlRecord(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private SiteUrlRecord(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static SiteUrlRecord getDefaultInstance() {
            return defaultInstance;
        }

        public SiteUrlRecord getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SiteUrlRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.idsite_ = input.readInt32();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.url_ = input.readBytes();
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_SiteUrlRecord_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_SiteUrlRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(SiteUrlRecord.class, Builder.class);
        }

        public Parser<SiteUrlRecord> getParserForType() {
            return PARSER;
        }

        public boolean hasIdsite() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public int getIdsite() {
            return this.idsite_;
        }

        public boolean hasUrl() {
            return (this.bitField0_ & 0x2) == 2;
        }

        public String getUrl() {
            Object ref = this.url_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.url_ = s;
            }
            return s;
        }

        public ByteString getUrlBytes() {
            Object ref = this.url_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.url_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.idsite_ = 0;
            this.url_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasIdsite()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasUrl()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeInt32(1, this.idsite_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeBytes(2, getUrlBytes());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeInt32Size(1, this.idsite_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size = size + CodedOutputStream.computeBytesSize(2, getUrlBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static SiteUrlRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SiteUrlRecord) PARSER.parseFrom(data);
        }

        public static SiteUrlRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SiteUrlRecord) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SiteUrlRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SiteUrlRecord) PARSER.parseFrom(data);
        }

        public static SiteUrlRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SiteUrlRecord) PARSER.parseFrom(data, extensionRegistry);
        }

        public static SiteUrlRecord parseFrom(InputStream input) throws IOException {
            return (SiteUrlRecord) PARSER.parseFrom(input);
        }

        public static SiteUrlRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SiteUrlRecord) PARSER.parseFrom(input, extensionRegistry);
        }

        public static SiteUrlRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (SiteUrlRecord) PARSER.parseDelimitedFrom(input);
        }

        public static SiteUrlRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SiteUrlRecord) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static SiteUrlRecord parseFrom(CodedInputStream input) throws IOException {
            return (SiteUrlRecord) PARSER.parseFrom(input);
        }

        public static SiteUrlRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SiteUrlRecord) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SiteUrlRecord prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.SiteUrlRecordOrBuilder {
            private int bitField0_;
            private int idsite_;
            private Object url_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_SiteUrlRecord_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_SiteUrlRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.SiteUrlRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                WebMsgProto.SiteUrlRecord.newBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.idsite_ = 0;
                this.bitField0_ &= -2;
                this.url_ = "";
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_SiteUrlRecord_descriptor;
            }

            public WebMsgProto.SiteUrlRecord getDefaultInstanceForType() {
                return WebMsgProto.SiteUrlRecord.getDefaultInstance();
            }

            public WebMsgProto.SiteUrlRecord build() {
                WebMsgProto.SiteUrlRecord result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.SiteUrlRecord buildPartial() {
                WebMsgProto.SiteUrlRecord result = new WebMsgProto.SiteUrlRecord(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.idsite_ = this.idsite_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.url_ = this.url_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.SiteUrlRecord)) {
                    return mergeFrom((WebMsgProto.SiteUrlRecord) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.SiteUrlRecord other) {
                if (other == WebMsgProto.SiteUrlRecord.getDefaultInstance())
                    return this;
                if (other.hasIdsite()) {
                    setIdsite(other.getIdsite());
                }
                if (other.hasUrl()) {
                    this.bitField0_ |= 2;
                    this.url_ = other.url_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasIdsite()) {
                    return false;
                }
                if (!hasUrl()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.SiteUrlRecord parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.SiteUrlRecord) WebMsgProto.SiteUrlRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.SiteUrlRecord) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasIdsite() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public int getIdsite() {
                return this.idsite_;
            }

            public Builder setIdsite(int value) {
                this.bitField0_ |= 1;
                this.idsite_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdsite() {
                this.bitField0_ &= -2;
                this.idsite_ = 0;
                onChanged();
                return this;
            }

            public boolean hasUrl() {
                return (this.bitField0_ & 0x2) == 2;
            }

            public String getUrl() {
                Object ref = this.url_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.url_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getUrlBytes() {
                Object ref = this.url_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.url_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.url_ = value;
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.bitField0_ &= -3;
                this.url_ = WebMsgProto.SiteUrlRecord.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            public Builder setUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.url_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static abstract interface SiteUrlRecordOrBuilder extends MessageOrBuilder {
        public abstract boolean hasIdsite();

        public abstract int getIdsite();

        public abstract boolean hasUrl();

        public abstract String getUrl();

        public abstract ByteString getUrlBytes();
    }

    public static final class Visitor extends GeneratedMessage implements WebMsgProto.VisitorOrBuilder {
        private static final Visitor defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<Visitor> PARSER = new AbstractParser() {
            public WebMsgProto.Visitor parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.Visitor(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int IDVISITOR_FIELD_NUMBER = 1;
        private ByteString idvisitor_;
        public static final int LOCALTIME_FIELD_NUMBER = 2;
        private int localtime_;
        public static final int RETURNING_FIELD_NUMBER = 3;
        private int returning_;
        public static final int COUNT_VISITS_FIELD_NUMBER = 4;
        private int countVisits_;
        public static final int DAYS_SINCE_LAST_FIELD_NUMBER = 5;
        private int daysSinceLast_;
        public static final int DAYS_SINCE_ORDER_FIELD_NUMBER = 6;
        private int daysSinceOrder_;
        public static final int DAYS_SINCE_FIRST_FIELD_NUMBER = 7;
        private int daysSinceFirst_;
        public static final int FIRST_ACTION_TIME_FIELD_NUMBER = 8;
        private long firstActionTime_;
        public static final int LAST_ACTION_TIME_FIELD_NUMBER = 9;
        private long lastActionTime_;
        public static final int EXIT_IDACTION_URL_FIELD_NUMBER = 10;
        private int exitIdactionUrl_;
        public static final int EXIT_IDACTION_NAME_FIELD_NUMBER = 11;
        private int exitIdactionName_;
        public static final int ENTRY_IDACTION_URL_FIELD_NUMBER = 12;
        private int entryIdactionUrl_;
        public static final int ENTRY_IDACTION_NAME_FIELD_NUMBER = 13;
        private int entryIdactionName_;
        public static final int TOTAL_ACTIONS_FIELD_NUMBER = 14;
        private int totalActions_;
        public static final int TOTAL_SEARCHES_FIELD_NUMBER = 15;
        private int totalSearches_;
        public static final int TOTAL_TIME_FIELD_NUMBER = 16;
        private int totalTime_;
        public static final int GOAL_CONVERTED_FIELD_NUMBER = 17;
        private int goalConverted_;
        public static final int GOAL_BUYER_FIELD_NUMBER = 18;
        private int goalBuyer_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new Visitor(true);
            defaultInstance.initFields();
        }

        private Visitor(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private Visitor(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static Visitor getDefaultInstance() {
            return defaultInstance;
        }

        public Visitor getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Visitor(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.idvisitor_ = input.readBytes();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.localtime_ = input.readInt32();
                            break;
                        case 24:
                            this.bitField0_ |= 4;
                            this.returning_ = input.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 8;
                            this.countVisits_ = input.readInt32();
                            break;
                        case 40:
                            this.bitField0_ |= 16;
                            this.daysSinceLast_ = input.readInt32();
                            break;
                        case 48:
                            this.bitField0_ |= 32;
                            this.daysSinceOrder_ = input.readInt32();
                            break;
                        case 56:
                            this.bitField0_ |= 64;
                            this.daysSinceFirst_ = input.readInt32();
                            break;
                        case 64:
                            this.bitField0_ |= 128;
                            this.firstActionTime_ = input.readInt64();
                            break;
                        case 72:
                            this.bitField0_ |= 256;
                            this.lastActionTime_ = input.readInt64();
                            break;
                        case 80:
                            this.bitField0_ |= 512;
                            this.exitIdactionUrl_ = input.readInt32();
                            break;
                        case 88:
                            this.bitField0_ |= 1024;
                            this.exitIdactionName_ = input.readInt32();
                            break;
                        case 96:
                            this.bitField0_ |= 2048;
                            this.entryIdactionUrl_ = input.readInt32();
                            break;
                        case 104:
                            this.bitField0_ |= 4096;
                            this.entryIdactionName_ = input.readInt32();
                            break;
                        case 112:
                            this.bitField0_ |= 8192;
                            this.totalActions_ = input.readInt32();
                            break;
                        case 120:
                            this.bitField0_ |= 16384;
                            this.totalSearches_ = input.readInt32();
                            break;
                        case 128:
                            this.bitField0_ |= 32768;
                            this.totalTime_ = input.readInt32();
                            break;
                        case 136:
                            this.bitField0_ |= 65536;
                            this.goalConverted_ = input.readInt32();
                            break;
                        case 144:
                            this.bitField0_ |= 131072;
                            this.goalBuyer_ = input.readInt32();
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_Visitor_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_Visitor_fieldAccessorTable.ensureFieldAccessorsInitialized(Visitor.class, Builder.class);
        }

        public Parser<Visitor> getParserForType() {
            return PARSER;
        }

        public boolean hasIdvisitor() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public ByteString getIdvisitor() {
            return this.idvisitor_;
        }

        public boolean hasLocaltime() {
            return (this.bitField0_ & 0x2) == 2;
        }

        public int getLocaltime() {
            return this.localtime_;
        }

        public boolean hasReturning() {
            return (this.bitField0_ & 0x4) == 4;
        }

        public int getReturning() {
            return this.returning_;
        }

        public boolean hasCountVisits() {
            return (this.bitField0_ & 0x8) == 8;
        }

        public int getCountVisits() {
            return this.countVisits_;
        }

        public boolean hasDaysSinceLast() {
            return (this.bitField0_ & 0x10) == 16;
        }

        public int getDaysSinceLast() {
            return this.daysSinceLast_;
        }

        public boolean hasDaysSinceOrder() {
            return (this.bitField0_ & 0x20) == 32;
        }

        public int getDaysSinceOrder() {
            return this.daysSinceOrder_;
        }

        public boolean hasDaysSinceFirst() {
            return (this.bitField0_ & 0x40) == 64;
        }

        public int getDaysSinceFirst() {
            return this.daysSinceFirst_;
        }

        public boolean hasFirstActionTime() {
            return (this.bitField0_ & 0x80) == 128;
        }

        public long getFirstActionTime() {
            return this.firstActionTime_;
        }

        public boolean hasLastActionTime() {
            return (this.bitField0_ & 0x100) == 256;
        }

        public long getLastActionTime() {
            return this.lastActionTime_;
        }

        public boolean hasExitIdactionUrl() {
            return (this.bitField0_ & 0x200) == 512;
        }

        public int getExitIdactionUrl() {
            return this.exitIdactionUrl_;
        }

        public boolean hasExitIdactionName() {
            return (this.bitField0_ & 0x400) == 1024;
        }

        public int getExitIdactionName() {
            return this.exitIdactionName_;
        }

        public boolean hasEntryIdactionUrl() {
            return (this.bitField0_ & 0x800) == 2048;
        }

        public int getEntryIdactionUrl() {
            return this.entryIdactionUrl_;
        }

        public boolean hasEntryIdactionName() {
            return (this.bitField0_ & 0x1000) == 4096;
        }

        public int getEntryIdactionName() {
            return this.entryIdactionName_;
        }

        public boolean hasTotalActions() {
            return (this.bitField0_ & 0x2000) == 8192;
        }

        public int getTotalActions() {
            return this.totalActions_;
        }

        public boolean hasTotalSearches() {
            return (this.bitField0_ & 0x4000) == 16384;
        }

        public int getTotalSearches() {
            return this.totalSearches_;
        }

        public boolean hasTotalTime() {
            return (this.bitField0_ & 0x8000) == 32768;
        }

        public int getTotalTime() {
            return this.totalTime_;
        }

        public boolean hasGoalConverted() {
            return (this.bitField0_ & 0x10000) == 65536;
        }

        public int getGoalConverted() {
            return this.goalConverted_;
        }

        public boolean hasGoalBuyer() {
            return (this.bitField0_ & 0x20000) == 131072;
        }

        public int getGoalBuyer() {
            return this.goalBuyer_;
        }

        private void initFields() {
            this.idvisitor_ = ByteString.EMPTY;
            this.localtime_ = 0;
            this.returning_ = 0;
            this.countVisits_ = 0;
            this.daysSinceLast_ = 0;
            this.daysSinceOrder_ = 0;
            this.daysSinceFirst_ = 0;
            this.firstActionTime_ = 0L;
            this.lastActionTime_ = 0L;
            this.exitIdactionUrl_ = 0;
            this.exitIdactionName_ = 0;
            this.entryIdactionUrl_ = 0;
            this.entryIdactionName_ = 0;
            this.totalActions_ = 0;
            this.totalSearches_ = 0;
            this.totalTime_ = 0;
            this.goalConverted_ = 0;
            this.goalBuyer_ = 0;
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasIdvisitor()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLocaltime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasReturning()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasCountVisits()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasDaysSinceLast()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasDaysSinceOrder()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasDaysSinceFirst()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasFirstActionTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLastActionTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasExitIdactionUrl()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasExitIdactionName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasEntryIdactionUrl()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasEntryIdactionName()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTotalActions()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTotalSearches()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasTotalTime()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasGoalConverted()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            if (!hasGoalBuyer()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, this.idvisitor_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                output.writeInt32(2, this.localtime_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                output.writeInt32(3, this.returning_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                output.writeInt32(4, this.countVisits_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                output.writeInt32(5, this.daysSinceLast_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                output.writeInt32(6, this.daysSinceOrder_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                output.writeInt32(7, this.daysSinceFirst_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                output.writeInt64(8, this.firstActionTime_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                output.writeInt64(9, this.lastActionTime_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                output.writeInt32(10, this.exitIdactionUrl_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                output.writeInt32(11, this.exitIdactionName_);
            }
            if ((this.bitField0_ & 0x800) == 2048) {
                output.writeInt32(12, this.entryIdactionUrl_);
            }
            if ((this.bitField0_ & 0x1000) == 4096) {
                output.writeInt32(13, this.entryIdactionName_);
            }
            if ((this.bitField0_ & 0x2000) == 8192) {
                output.writeInt32(14, this.totalActions_);
            }
            if ((this.bitField0_ & 0x4000) == 16384) {
                output.writeInt32(15, this.totalSearches_);
            }
            if ((this.bitField0_ & 0x8000) == 32768) {
                output.writeInt32(16, this.totalTime_);
            }
            if ((this.bitField0_ & 0x10000) == 65536) {
                output.writeInt32(17, this.goalConverted_);
            }
            if ((this.bitField0_ & 0x20000) == 131072) {
                output.writeInt32(18, this.goalBuyer_);
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeBytesSize(1, this.idvisitor_);
            }
            if ((this.bitField0_ & 0x2) == 2) {
                size = size + CodedOutputStream.computeInt32Size(2, this.localtime_);
            }
            if ((this.bitField0_ & 0x4) == 4) {
                size = size + CodedOutputStream.computeInt32Size(3, this.returning_);
            }
            if ((this.bitField0_ & 0x8) == 8) {
                size = size + CodedOutputStream.computeInt32Size(4, this.countVisits_);
            }
            if ((this.bitField0_ & 0x10) == 16) {
                size = size + CodedOutputStream.computeInt32Size(5, this.daysSinceLast_);
            }
            if ((this.bitField0_ & 0x20) == 32) {
                size = size + CodedOutputStream.computeInt32Size(6, this.daysSinceOrder_);
            }
            if ((this.bitField0_ & 0x40) == 64) {
                size = size + CodedOutputStream.computeInt32Size(7, this.daysSinceFirst_);
            }
            if ((this.bitField0_ & 0x80) == 128) {
                size = size + CodedOutputStream.computeInt64Size(8, this.firstActionTime_);
            }
            if ((this.bitField0_ & 0x100) == 256) {
                size = size + CodedOutputStream.computeInt64Size(9, this.lastActionTime_);
            }
            if ((this.bitField0_ & 0x200) == 512) {
                size = size + CodedOutputStream.computeInt32Size(10, this.exitIdactionUrl_);
            }
            if ((this.bitField0_ & 0x400) == 1024) {
                size = size + CodedOutputStream.computeInt32Size(11, this.exitIdactionName_);
            }
            if ((this.bitField0_ & 0x800) == 2048) {
                size = size + CodedOutputStream.computeInt32Size(12, this.entryIdactionUrl_);
            }
            if ((this.bitField0_ & 0x1000) == 4096) {
                size = size + CodedOutputStream.computeInt32Size(13, this.entryIdactionName_);
            }
            if ((this.bitField0_ & 0x2000) == 8192) {
                size = size + CodedOutputStream.computeInt32Size(14, this.totalActions_);
            }
            if ((this.bitField0_ & 0x4000) == 16384) {
                size = size + CodedOutputStream.computeInt32Size(15, this.totalSearches_);
            }
            if ((this.bitField0_ & 0x8000) == 32768) {
                size = size + CodedOutputStream.computeInt32Size(16, this.totalTime_);
            }
            if ((this.bitField0_ & 0x10000) == 65536) {
                size = size + CodedOutputStream.computeInt32Size(17, this.goalConverted_);
            }
            if ((this.bitField0_ & 0x20000) == 131072) {
                size = size + CodedOutputStream.computeInt32Size(18, this.goalBuyer_);
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static Visitor parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Visitor) PARSER.parseFrom(data);
        }

        public static Visitor parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Visitor) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Visitor parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Visitor) PARSER.parseFrom(data);
        }

        public static Visitor parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Visitor) PARSER.parseFrom(data, extensionRegistry);
        }

        public static Visitor parseFrom(InputStream input) throws IOException {
            return (Visitor) PARSER.parseFrom(input);
        }

        public static Visitor parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Visitor) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Visitor parseDelimitedFrom(InputStream input) throws IOException {
            return (Visitor) PARSER.parseDelimitedFrom(input);
        }

        public static Visitor parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Visitor) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static Visitor parseFrom(CodedInputStream input) throws IOException {
            return (Visitor) PARSER.parseFrom(input);
        }

        public static Visitor parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Visitor) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(Visitor prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.VisitorOrBuilder {
            private int bitField0_;
            private ByteString idvisitor_ = ByteString.EMPTY;
            private int localtime_;
            private int returning_;
            private int countVisits_;
            private int daysSinceLast_;
            private int daysSinceOrder_;
            private int daysSinceFirst_;
            private long firstActionTime_;
            private long lastActionTime_;
            private int exitIdactionUrl_;
            private int exitIdactionName_;
            private int entryIdactionUrl_;
            private int entryIdactionName_;
            private int totalActions_;
            private int totalSearches_;
            private int totalTime_;
            private int goalConverted_;
            private int goalBuyer_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_Visitor_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_Visitor_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.Visitor.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                WebMsgProto.Visitor.newBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.idvisitor_ = ByteString.EMPTY;
                this.bitField0_ &= -2;
                this.localtime_ = 0;
                this.bitField0_ &= -3;
                this.returning_ = 0;
                this.bitField0_ &= -5;
                this.countVisits_ = 0;
                this.bitField0_ &= -9;
                this.daysSinceLast_ = 0;
                this.bitField0_ &= -17;
                this.daysSinceOrder_ = 0;
                this.bitField0_ &= -33;
                this.daysSinceFirst_ = 0;
                this.bitField0_ &= -65;
                this.firstActionTime_ = 0L;
                this.bitField0_ &= -129;
                this.lastActionTime_ = 0L;
                this.bitField0_ &= -257;
                this.exitIdactionUrl_ = 0;
                this.bitField0_ &= -513;
                this.exitIdactionName_ = 0;
                this.bitField0_ &= -1025;
                this.entryIdactionUrl_ = 0;
                this.bitField0_ &= -2049;
                this.entryIdactionName_ = 0;
                this.bitField0_ &= -4097;
                this.totalActions_ = 0;
                this.bitField0_ &= -8193;
                this.totalSearches_ = 0;
                this.bitField0_ &= -16385;
                this.totalTime_ = 0;
                this.bitField0_ &= -32769;
                this.goalConverted_ = 0;
                this.bitField0_ &= -65537;
                this.goalBuyer_ = 0;
                this.bitField0_ &= -131073;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_Visitor_descriptor;
            }

            public WebMsgProto.Visitor getDefaultInstanceForType() {
                return WebMsgProto.Visitor.getDefaultInstance();
            }

            public WebMsgProto.Visitor build() {
                WebMsgProto.Visitor result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.Visitor buildPartial() {
                WebMsgProto.Visitor result = new WebMsgProto.Visitor(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.idvisitor_ = this.idvisitor_;
                if ((from_bitField0_ & 0x2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.localtime_ = this.localtime_;
                if ((from_bitField0_ & 0x4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.returning_ = this.returning_;
                if ((from_bitField0_ & 0x8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.countVisits_ = this.countVisits_;
                if ((from_bitField0_ & 0x10) == 16) {
                    to_bitField0_ |= 16;
                }
                result.daysSinceLast_ = this.daysSinceLast_;
                if ((from_bitField0_ & 0x20) == 32) {
                    to_bitField0_ |= 32;
                }
                result.daysSinceOrder_ = this.daysSinceOrder_;
                if ((from_bitField0_ & 0x40) == 64) {
                    to_bitField0_ |= 64;
                }
                result.daysSinceFirst_ = this.daysSinceFirst_;
                if ((from_bitField0_ & 0x80) == 128) {
                    to_bitField0_ |= 128;
                }
                result.firstActionTime_ = this.firstActionTime_;
                if ((from_bitField0_ & 0x100) == 256) {
                    to_bitField0_ |= 256;
                }
                result.lastActionTime_ = this.lastActionTime_;
                if ((from_bitField0_ & 0x200) == 512) {
                    to_bitField0_ |= 512;
                }
                result.exitIdactionUrl_ = this.exitIdactionUrl_;
                if ((from_bitField0_ & 0x400) == 1024) {
                    to_bitField0_ |= 1024;
                }
                result.exitIdactionName_ = this.exitIdactionName_;
                if ((from_bitField0_ & 0x800) == 2048) {
                    to_bitField0_ |= 2048;
                }
                result.entryIdactionUrl_ = this.entryIdactionUrl_;
                if ((from_bitField0_ & 0x1000) == 4096) {
                    to_bitField0_ |= 4096;
                }
                result.entryIdactionName_ = this.entryIdactionName_;
                if ((from_bitField0_ & 0x2000) == 8192) {
                    to_bitField0_ |= 8192;
                }
                result.totalActions_ = this.totalActions_;
                if ((from_bitField0_ & 0x4000) == 16384) {
                    to_bitField0_ |= 16384;
                }
                result.totalSearches_ = this.totalSearches_;
                if ((from_bitField0_ & 0x8000) == 32768) {
                    to_bitField0_ |= 32768;
                }
                result.totalTime_ = this.totalTime_;
                if ((from_bitField0_ & 0x10000) == 65536) {
                    to_bitField0_ |= 65536;
                }
                result.goalConverted_ = this.goalConverted_;
                if ((from_bitField0_ & 0x20000) == 131072) {
                    to_bitField0_ |= 131072;
                }
                result.goalBuyer_ = this.goalBuyer_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.Visitor)) {
                    return mergeFrom((WebMsgProto.Visitor) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.Visitor other) {
                if (other == WebMsgProto.Visitor.getDefaultInstance())
                    return this;
                if (other.hasIdvisitor()) {
                    setIdvisitor(other.getIdvisitor());
                }
                if (other.hasLocaltime()) {
                    setLocaltime(other.getLocaltime());
                }
                if (other.hasReturning()) {
                    setReturning(other.getReturning());
                }
                if (other.hasCountVisits()) {
                    setCountVisits(other.getCountVisits());
                }
                if (other.hasDaysSinceLast()) {
                    setDaysSinceLast(other.getDaysSinceLast());
                }
                if (other.hasDaysSinceOrder()) {
                    setDaysSinceOrder(other.getDaysSinceOrder());
                }
                if (other.hasDaysSinceFirst()) {
                    setDaysSinceFirst(other.getDaysSinceFirst());
                }
                if (other.hasFirstActionTime()) {
                    setFirstActionTime(other.getFirstActionTime());
                }
                if (other.hasLastActionTime()) {
                    setLastActionTime(other.getLastActionTime());
                }
                if (other.hasExitIdactionUrl()) {
                    setExitIdactionUrl(other.getExitIdactionUrl());
                }
                if (other.hasExitIdactionName()) {
                    setExitIdactionName(other.getExitIdactionName());
                }
                if (other.hasEntryIdactionUrl()) {
                    setEntryIdactionUrl(other.getEntryIdactionUrl());
                }
                if (other.hasEntryIdactionName()) {
                    setEntryIdactionName(other.getEntryIdactionName());
                }
                if (other.hasTotalActions()) {
                    setTotalActions(other.getTotalActions());
                }
                if (other.hasTotalSearches()) {
                    setTotalSearches(other.getTotalSearches());
                }
                if (other.hasTotalTime()) {
                    setTotalTime(other.getTotalTime());
                }
                if (other.hasGoalConverted()) {
                    setGoalConverted(other.getGoalConverted());
                }
                if (other.hasGoalBuyer()) {
                    setGoalBuyer(other.getGoalBuyer());
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasIdvisitor()) {
                    return false;
                }
                if (!hasLocaltime()) {
                    return false;
                }
                if (!hasReturning()) {
                    return false;
                }
                if (!hasCountVisits()) {
                    return false;
                }
                if (!hasDaysSinceLast()) {
                    return false;
                }
                if (!hasDaysSinceOrder()) {
                    return false;
                }
                if (!hasDaysSinceFirst()) {
                    return false;
                }
                if (!hasFirstActionTime()) {
                    return false;
                }
                if (!hasLastActionTime()) {
                    return false;
                }
                if (!hasExitIdactionUrl()) {
                    return false;
                }
                if (!hasExitIdactionName()) {
                    return false;
                }
                if (!hasEntryIdactionUrl()) {
                    return false;
                }
                if (!hasEntryIdactionName()) {
                    return false;
                }
                if (!hasTotalActions()) {
                    return false;
                }
                if (!hasTotalSearches()) {
                    return false;
                }
                if (!hasTotalTime()) {
                    return false;
                }
                if (!hasGoalConverted()) {
                    return false;
                }
                if (!hasGoalBuyer()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.Visitor parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.Visitor) WebMsgProto.Visitor.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.Visitor) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasIdvisitor() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public ByteString getIdvisitor() {
                return this.idvisitor_;
            }

            public Builder setIdvisitor(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.idvisitor_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdvisitor() {
                this.bitField0_ &= -2;
                this.idvisitor_ = WebMsgProto.Visitor.getDefaultInstance().getIdvisitor();
                onChanged();
                return this;
            }

            public boolean hasLocaltime() {
                return (this.bitField0_ & 0x2) == 2;
            }

            public int getLocaltime() {
                return this.localtime_;
            }

            public Builder setLocaltime(int value) {
                this.bitField0_ |= 2;
                this.localtime_ = value;
                onChanged();
                return this;
            }

            public Builder clearLocaltime() {
                this.bitField0_ &= -3;
                this.localtime_ = 0;
                onChanged();
                return this;
            }

            public boolean hasReturning() {
                return (this.bitField0_ & 0x4) == 4;
            }

            public int getReturning() {
                return this.returning_;
            }

            public Builder setReturning(int value) {
                this.bitField0_ |= 4;
                this.returning_ = value;
                onChanged();
                return this;
            }

            public Builder clearReturning() {
                this.bitField0_ &= -5;
                this.returning_ = 0;
                onChanged();
                return this;
            }

            public boolean hasCountVisits() {
                return (this.bitField0_ & 0x8) == 8;
            }

            public int getCountVisits() {
                return this.countVisits_;
            }

            public Builder setCountVisits(int value) {
                this.bitField0_ |= 8;
                this.countVisits_ = value;
                onChanged();
                return this;
            }

            public Builder clearCountVisits() {
                this.bitField0_ &= -9;
                this.countVisits_ = 0;
                onChanged();
                return this;
            }

            public boolean hasDaysSinceLast() {
                return (this.bitField0_ & 0x10) == 16;
            }

            public int getDaysSinceLast() {
                return this.daysSinceLast_;
            }

            public Builder setDaysSinceLast(int value) {
                this.bitField0_ |= 16;
                this.daysSinceLast_ = value;
                onChanged();
                return this;
            }

            public Builder clearDaysSinceLast() {
                this.bitField0_ &= -17;
                this.daysSinceLast_ = 0;
                onChanged();
                return this;
            }

            public boolean hasDaysSinceOrder() {
                return (this.bitField0_ & 0x20) == 32;
            }

            public int getDaysSinceOrder() {
                return this.daysSinceOrder_;
            }

            public Builder setDaysSinceOrder(int value) {
                this.bitField0_ |= 32;
                this.daysSinceOrder_ = value;
                onChanged();
                return this;
            }

            public Builder clearDaysSinceOrder() {
                this.bitField0_ &= -33;
                this.daysSinceOrder_ = 0;
                onChanged();
                return this;
            }

            public boolean hasDaysSinceFirst() {
                return (this.bitField0_ & 0x40) == 64;
            }

            public int getDaysSinceFirst() {
                return this.daysSinceFirst_;
            }

            public Builder setDaysSinceFirst(int value) {
                this.bitField0_ |= 64;
                this.daysSinceFirst_ = value;
                onChanged();
                return this;
            }

            public Builder clearDaysSinceFirst() {
                this.bitField0_ &= -65;
                this.daysSinceFirst_ = 0;
                onChanged();
                return this;
            }

            public boolean hasFirstActionTime() {
                return (this.bitField0_ & 0x80) == 128;
            }

            public long getFirstActionTime() {
                return this.firstActionTime_;
            }

            public Builder setFirstActionTime(long value) {
                this.bitField0_ |= 128;
                this.firstActionTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearFirstActionTime() {
                this.bitField0_ &= -129;
                this.firstActionTime_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasLastActionTime() {
                return (this.bitField0_ & 0x100) == 256;
            }

            public long getLastActionTime() {
                return this.lastActionTime_;
            }

            public Builder setLastActionTime(long value) {
                this.bitField0_ |= 256;
                this.lastActionTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastActionTime() {
                this.bitField0_ &= -257;
                this.lastActionTime_ = 0L;
                onChanged();
                return this;
            }

            public boolean hasExitIdactionUrl() {
                return (this.bitField0_ & 0x200) == 512;
            }

            public int getExitIdactionUrl() {
                return this.exitIdactionUrl_;
            }

            public Builder setExitIdactionUrl(int value) {
                this.bitField0_ |= 512;
                this.exitIdactionUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearExitIdactionUrl() {
                this.bitField0_ &= -513;
                this.exitIdactionUrl_ = 0;
                onChanged();
                return this;
            }

            public boolean hasExitIdactionName() {
                return (this.bitField0_ & 0x400) == 1024;
            }

            public int getExitIdactionName() {
                return this.exitIdactionName_;
            }

            public Builder setExitIdactionName(int value) {
                this.bitField0_ |= 1024;
                this.exitIdactionName_ = value;
                onChanged();
                return this;
            }

            public Builder clearExitIdactionName() {
                this.bitField0_ &= -1025;
                this.exitIdactionName_ = 0;
                onChanged();
                return this;
            }

            public boolean hasEntryIdactionUrl() {
                return (this.bitField0_ & 0x800) == 2048;
            }

            public int getEntryIdactionUrl() {
                return this.entryIdactionUrl_;
            }

            public Builder setEntryIdactionUrl(int value) {
                this.bitField0_ |= 2048;
                this.entryIdactionUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntryIdactionUrl() {
                this.bitField0_ &= -2049;
                this.entryIdactionUrl_ = 0;
                onChanged();
                return this;
            }

            public boolean hasEntryIdactionName() {
                return (this.bitField0_ & 0x1000) == 4096;
            }

            public int getEntryIdactionName() {
                return this.entryIdactionName_;
            }

            public Builder setEntryIdactionName(int value) {
                this.bitField0_ |= 4096;
                this.entryIdactionName_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntryIdactionName() {
                this.bitField0_ &= -4097;
                this.entryIdactionName_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTotalActions() {
                return (this.bitField0_ & 0x2000) == 8192;
            }

            public int getTotalActions() {
                return this.totalActions_;
            }

            public Builder setTotalActions(int value) {
                this.bitField0_ |= 8192;
                this.totalActions_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalActions() {
                this.bitField0_ &= -8193;
                this.totalActions_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTotalSearches() {
                return (this.bitField0_ & 0x4000) == 16384;
            }

            public int getTotalSearches() {
                return this.totalSearches_;
            }

            public Builder setTotalSearches(int value) {
                this.bitField0_ |= 16384;
                this.totalSearches_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalSearches() {
                this.bitField0_ &= -16385;
                this.totalSearches_ = 0;
                onChanged();
                return this;
            }

            public boolean hasTotalTime() {
                return (this.bitField0_ & 0x8000) == 32768;
            }

            public int getTotalTime() {
                return this.totalTime_;
            }

            public Builder setTotalTime(int value) {
                this.bitField0_ |= 32768;
                this.totalTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalTime() {
                this.bitField0_ &= -32769;
                this.totalTime_ = 0;
                onChanged();
                return this;
            }

            public boolean hasGoalConverted() {
                return (this.bitField0_ & 0x10000) == 65536;
            }

            public int getGoalConverted() {
                return this.goalConverted_;
            }

            public Builder setGoalConverted(int value) {
                this.bitField0_ |= 65536;
                this.goalConverted_ = value;
                onChanged();
                return this;
            }

            public Builder clearGoalConverted() {
                this.bitField0_ &= -65537;
                this.goalConverted_ = 0;
                onChanged();
                return this;
            }

            public boolean hasGoalBuyer() {
                return (this.bitField0_ & 0x20000) == 131072;
            }

            public int getGoalBuyer() {
                return this.goalBuyer_;
            }

            public Builder setGoalBuyer(int value) {
                this.bitField0_ |= 131072;
                this.goalBuyer_ = value;
                onChanged();
                return this;
            }

            public Builder clearGoalBuyer() {
                this.bitField0_ &= -131073;
                this.goalBuyer_ = 0;
                onChanged();
                return this;
            }
        }
    }

    public static abstract interface VisitorOrBuilder extends MessageOrBuilder {
        public abstract boolean hasIdvisitor();

        public abstract ByteString getIdvisitor();

        public abstract boolean hasLocaltime();

        public abstract int getLocaltime();

        public abstract boolean hasReturning();

        public abstract int getReturning();

        public abstract boolean hasCountVisits();

        public abstract int getCountVisits();

        public abstract boolean hasDaysSinceLast();

        public abstract int getDaysSinceLast();

        public abstract boolean hasDaysSinceOrder();

        public abstract int getDaysSinceOrder();

        public abstract boolean hasDaysSinceFirst();

        public abstract int getDaysSinceFirst();

        public abstract boolean hasFirstActionTime();

        public abstract long getFirstActionTime();

        public abstract boolean hasLastActionTime();

        public abstract long getLastActionTime();

        public abstract boolean hasExitIdactionUrl();

        public abstract int getExitIdactionUrl();

        public abstract boolean hasExitIdactionName();

        public abstract int getExitIdactionName();

        public abstract boolean hasEntryIdactionUrl();

        public abstract int getEntryIdactionUrl();

        public abstract boolean hasEntryIdactionName();

        public abstract int getEntryIdactionName();

        public abstract boolean hasTotalActions();

        public abstract int getTotalActions();

        public abstract boolean hasTotalSearches();

        public abstract int getTotalSearches();

        public abstract boolean hasTotalTime();

        public abstract int getTotalTime();

        public abstract boolean hasGoalConverted();

        public abstract int getGoalConverted();

        public abstract boolean hasGoalBuyer();

        public abstract int getGoalBuyer();
    }

    public static final class WebItem extends GeneratedMessage implements WebMsgProto.WebItemOrBuilder {
        private static final WebItem defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<WebItem> PARSER = new AbstractParser() {
            public WebMsgProto.WebItem parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WebMsgProto.WebItem(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int MSGPACK_FIELD_NUMBER = 1;
        private Object msgpack_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new WebItem(true);
            defaultInstance.initFields();
        }

        private WebItem(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private WebItem(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static WebItem getDefaultInstance() {
            return defaultInstance;
        }

        public WebItem getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WebItem(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            initFields();
            int mutable_bitField0_ = 0;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.msgpack_ = input.readBytes();
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WebMsgProto.internal_static_pbmsg_WebItem_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return WebMsgProto.internal_static_pbmsg_WebItem_fieldAccessorTable.ensureFieldAccessorsInitialized(WebItem.class, Builder.class);
        }

        public Parser<WebItem> getParserForType() {
            return PARSER;
        }

        public boolean hasMsgpack() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public String getMsgpack() {
            Object ref = this.msgpack_;
            if ((ref instanceof String)) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.msgpack_ = s;
            }
            return s;
        }

        public ByteString getMsgpackBytes() {
            Object ref = this.msgpack_;
            if ((ref instanceof String)) {
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.msgpack_ = b;
                return b;
            }
            return (ByteString) ref;
        }

        private void initFields() {
            this.msgpack_ = "";
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasMsgpack()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 0x1) == 1) {
                output.writeBytes(1, getMsgpackBytes());
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeBytesSize(1, getMsgpackBytes());
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static WebItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (WebItem) PARSER.parseFrom(data);
        }

        public static WebItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WebItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WebItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (WebItem) PARSER.parseFrom(data);
        }

        public static WebItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (WebItem) PARSER.parseFrom(data, extensionRegistry);
        }

        public static WebItem parseFrom(InputStream input) throws IOException {
            return (WebItem) PARSER.parseFrom(input);
        }

        public static WebItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WebItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static WebItem parseDelimitedFrom(InputStream input) throws IOException {
            return (WebItem) PARSER.parseDelimitedFrom(input);
        }

        public static WebItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WebItem) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static WebItem parseFrom(CodedInputStream input) throws IOException {
            return (WebItem) PARSER.parseFrom(input);
        }

        public static WebItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WebItem) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(WebItem prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements WebMsgProto.WebItemOrBuilder {
            private int bitField0_;
            private Object msgpack_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return WebMsgProto.internal_static_pbmsg_WebItem_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return WebMsgProto.internal_static_pbmsg_WebItem_fieldAccessorTable.ensureFieldAccessorsInitialized(WebMsgProto.WebItem.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                WebMsgProto.WebItem.newBuilder();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.msgpack_ = "";
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return WebMsgProto.internal_static_pbmsg_WebItem_descriptor;
            }

            public WebMsgProto.WebItem getDefaultInstanceForType() {
                return WebMsgProto.WebItem.getDefaultInstance();
            }

            public WebMsgProto.WebItem build() {
                WebMsgProto.WebItem result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public WebMsgProto.WebItem buildPartial() {
                WebMsgProto.WebItem result = new WebMsgProto.WebItem(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.msgpack_ = this.msgpack_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof WebMsgProto.WebItem)) {
                    return mergeFrom((WebMsgProto.WebItem) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebMsgProto.WebItem other) {
                if (other == WebMsgProto.WebItem.getDefaultInstance())
                    return this;
                if (other.hasMsgpack()) {
                    this.bitField0_ |= 1;
                    this.msgpack_ = other.msgpack_;
                    onChanged();
                }
                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasMsgpack()) {
                    return false;
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                WebMsgProto.WebItem parsedMessage = null;
                try {
                    parsedMessage = (WebMsgProto.WebItem) WebMsgProto.WebItem.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (WebMsgProto.WebItem) e.getUnfinishedMessage();
                    throw e;
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            public boolean hasMsgpack() {
                return (this.bitField0_ & 0x1) == 1;
            }

            public String getMsgpack() {
                Object ref = this.msgpack_;
                if (!(ref instanceof String)) {
                    String s = ((ByteString) ref).toStringUtf8();
                    this.msgpack_ = s;
                    return s;
                }
                return (String) ref;
            }

            public ByteString getMsgpackBytes() {
                Object ref = this.msgpack_;
                if ((ref instanceof String)) {
                    ByteString b = ByteString.copyFromUtf8((String) ref);
                    this.msgpack_ = b;
                    return b;
                }
                return (ByteString) ref;
            }

            public Builder setMsgpack(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.msgpack_ = value;
                onChanged();
                return this;
            }

            public Builder clearMsgpack() {
                this.bitField0_ &= -2;
                this.msgpack_ = WebMsgProto.WebItem.getDefaultInstance().getMsgpack();
                onChanged();
                return this;
            }

            public Builder setMsgpackBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.msgpack_ = value;
                onChanged();
                return this;
            }
        }
    }

    public static abstract interface WebItemOrBuilder extends MessageOrBuilder {
        public abstract boolean hasMsgpack();

        public abstract String getMsgpack();

        public abstract ByteString getMsgpackBytes();
    }
}