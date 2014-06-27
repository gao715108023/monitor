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
import com.google.protobuf.UnknownFieldSet;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ClientMsgProtos {
    private static Descriptors.Descriptor internal_static_pbmsg_ClientLog_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_pbmsg_ClientLog_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    static {
        String[] descriptorData = {"\n\017clientmsg.proto\022\005pbmsg\032\013pcmsg.proto\032\fwebmsg.proto\"X\n\tClientLog\022\013\n\003key\030\001 \002(\005\022\035\n\006pcItem\030\002 \003(\0132\r.pbmsg.PCItem\022\037\n\007webItem\030\003 \003(\0132\016.pbmsg.WebItemB&\n\023com.gw.common.pbmsgB\017ClientMsgProtos"};

        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                ClientMsgProtos.descriptor = root;
                ClientMsgProtos.internal_static_pbmsg_ClientLog_descriptor = (Descriptors.Descriptor) ClientMsgProtos.getDescriptor().getMessageTypes().get(0);
                ClientMsgProtos.internal_static_pbmsg_ClientLog_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(ClientMsgProtos.internal_static_pbmsg_ClientLog_descriptor, new String[]{"Key", "PcItem", "WebItem"});
                return null;
            }
        };
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{PCMsgProto.getDescriptor(), WebMsgProto.getDescriptor()}, assigner);
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static final class ClientLog extends GeneratedMessage implements ClientMsgProtos.ClientLogOrBuilder {
        private static final ClientLog defaultInstance;
        private final UnknownFieldSet unknownFields;
        public static Parser<ClientLog> PARSER = new AbstractParser() {
            public ClientMsgProtos.ClientLog parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ClientMsgProtos.ClientLog(input, extensionRegistry);
            }
        };
        private int bitField0_;
        public static final int KEY_FIELD_NUMBER = 1;
        private int key_;
        public static final int PCITEM_FIELD_NUMBER = 2;
        private List<PCMsgProto.PCItem> pcItem_;
        public static final int WEBITEM_FIELD_NUMBER = 3;
        private List<WebMsgProto.WebItem> webItem_;
        private byte memoizedIsInitialized = -1;

        private int memoizedSerializedSize = -1;
        private static final long serialVersionUID = 0L;

        static {
            defaultInstance = new ClientLog(true);
            defaultInstance.initFields();
        }

        private ClientLog(GeneratedMessage.Builder<?> builder) {
            super();
            this.unknownFields = builder.getUnknownFields();
        }

        private ClientLog(boolean noInit) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        public static ClientLog getDefaultInstance() {
            return defaultInstance;
        }

        public ClientLog getDefaultInstanceForType() {
            return defaultInstance;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ClientLog(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            this.key_ = input.readInt32();
                            break;
                        case 18:
                            if ((mutable_bitField0_ & 0x2) != 2) {
                                this.pcItem_ = new ArrayList();
                                mutable_bitField0_ |= 2;
                            }
                            this.pcItem_.add((PCMsgProto.PCItem) input.readMessage(PCMsgProto.PCItem.PARSER, extensionRegistry));
                            break;
                        case 26:
                            if ((mutable_bitField0_ & 0x4) != 4) {
                                this.webItem_ = new ArrayList();
                                mutable_bitField0_ |= 4;
                            }
                            this.webItem_.add((WebMsgProto.WebItem) input.readMessage(WebMsgProto.WebItem.PARSER, extensionRegistry));
                    }
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
            } finally {
                if ((mutable_bitField0_ & 0x2) == 2) {
                    this.pcItem_ = Collections.unmodifiableList(this.pcItem_);
                }
                if ((mutable_bitField0_ & 0x4) == 4) {
                    this.webItem_ = Collections.unmodifiableList(this.webItem_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ClientMsgProtos.internal_static_pbmsg_ClientLog_descriptor;
        }

        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ClientMsgProtos.internal_static_pbmsg_ClientLog_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientLog.class, Builder.class);
        }

        public Parser<ClientLog> getParserForType() {
            return PARSER;
        }

        public boolean hasKey() {
            return (this.bitField0_ & 0x1) == 1;
        }

        public int getKey() {
            return this.key_;
        }

        public List<PCMsgProto.PCItem> getPcItemList() {
            return this.pcItem_;
        }

        public List<? extends PCMsgProto.PCItemOrBuilder> getPcItemOrBuilderList() {
            return this.pcItem_;
        }

        public int getPcItemCount() {
            return this.pcItem_.size();
        }

        public PCMsgProto.PCItem getPcItem(int index) {
            return (PCMsgProto.PCItem) this.pcItem_.get(index);
        }

        public PCMsgProto.PCItemOrBuilder getPcItemOrBuilder(int index) {
            return (PCMsgProto.PCItemOrBuilder) this.pcItem_.get(index);
        }

        public List<WebMsgProto.WebItem> getWebItemList() {
            return this.webItem_;
        }

        public List<? extends WebMsgProto.WebItemOrBuilder> getWebItemOrBuilderList() {
            return this.webItem_;
        }

        public int getWebItemCount() {
            return this.webItem_.size();
        }

        public WebMsgProto.WebItem getWebItem(int index) {
            return (WebMsgProto.WebItem) this.webItem_.get(index);
        }

        public WebMsgProto.WebItemOrBuilder getWebItemOrBuilder(int index) {
            return (WebMsgProto.WebItemOrBuilder) this.webItem_.get(index);
        }

        private void initFields() {
            this.key_ = 0;
            this.pcItem_ = Collections.emptyList();
            this.webItem_ = Collections.emptyList();
        }

        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1)
                return isInitialized == 1;

            if (!hasKey()) {
                this.memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getPcItemCount(); i++) {
                if (!getPcItem(i).isInitialized()) {
                    this.memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i = 0; i < getWebItemCount(); i++) {
                if (!getWebItem(i).isInitialized()) {
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
                output.writeInt32(1, this.key_);
            }
            for (int i = 0; i < this.pcItem_.size(); i++) {
                output.writeMessage(2, (MessageLite) this.pcItem_.get(i));
            }
            for (int i = 0; i < this.webItem_.size(); i++) {
                output.writeMessage(3, (MessageLite) this.webItem_.get(i));
            }
            getUnknownFields().writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1)
                return size;

            size = 0;
            if ((this.bitField0_ & 0x1) == 1) {
                size = size + CodedOutputStream.computeInt32Size(1, this.key_);
            }
            for (int i = 0; i < this.pcItem_.size(); i++) {
                size = size + CodedOutputStream.computeMessageSize(2, (MessageLite) this.pcItem_.get(i));
            }
            for (int i = 0; i < this.webItem_.size(); i++) {
                size = size + CodedOutputStream.computeMessageSize(3, (MessageLite) this.webItem_.get(i));
            }
            size += getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size;
            return size;
        }

        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static ClientLog parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ClientLog) PARSER.parseFrom(data);
        }

        public static ClientLog parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ClientLog) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientLog parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ClientLog) PARSER.parseFrom(data);
        }

        public static ClientLog parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ClientLog) PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientLog parseFrom(InputStream input) throws IOException {
            return (ClientLog) PARSER.parseFrom(input);
        }

        public static ClientLog parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientLog) PARSER.parseFrom(input, extensionRegistry);
        }

        public static ClientLog parseDelimitedFrom(InputStream input) throws IOException {
            return (ClientLog) PARSER.parseDelimitedFrom(input);
        }

        public static ClientLog parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientLog) PARSER.parseDelimitedFrom(input, extensionRegistry);
        }

        public static ClientLog parseFrom(CodedInputStream input) throws IOException {
            return (ClientLog) PARSER.parseFrom(input);
        }

        public static ClientLog parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientLog) PARSER.parseFrom(input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ClientLog prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        protected Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ClientMsgProtos.ClientLogOrBuilder {
            private int bitField0_;
            private int key_;
            private List<PCMsgProto.PCItem> pcItem_ = Collections.emptyList();
            private RepeatedFieldBuilder<PCMsgProto.PCItem, PCMsgProto.PCItem.Builder, PCMsgProto.PCItemOrBuilder> pcItemBuilder_;
            private List<WebMsgProto.WebItem> webItem_ = Collections.emptyList();
            private RepeatedFieldBuilder<WebMsgProto.WebItem, WebMsgProto.WebItem.Builder, WebMsgProto.WebItemOrBuilder> webItemBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ClientMsgProtos.internal_static_pbmsg_ClientLog_descriptor;
            }

            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return ClientMsgProtos.internal_static_pbmsg_ClientLog_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientMsgProtos.ClientLog.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ClientMsgProtos.ClientLog.alwaysUseFieldBuilders) {
                    getPcItemFieldBuilder();
                    getWebItemFieldBuilder();
                }
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder clear() {
                super.clear();
                this.key_ = 0;
                this.bitField0_ &= -2;
                if (this.pcItemBuilder_ == null) {
                    this.pcItem_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.pcItemBuilder_.clear();
                }
                if (this.webItemBuilder_ == null) {
                    this.webItem_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.webItemBuilder_.clear();
                }
                return this;
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return ClientMsgProtos.internal_static_pbmsg_ClientLog_descriptor;
            }

            public ClientMsgProtos.ClientLog getDefaultInstanceForType() {
                return ClientMsgProtos.ClientLog.getDefaultInstance();
            }

            public ClientMsgProtos.ClientLog build() {
                ClientMsgProtos.ClientLog result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public ClientMsgProtos.ClientLog buildPartial() {
                ClientMsgProtos.ClientLog result = new ClientMsgProtos.ClientLog(this);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x1) == 1) {
                    to_bitField0_ |= 1;
                }
                result.key_ = this.key_;
                if (this.pcItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x2) == 2) {
                        this.pcItem_ = Collections.unmodifiableList(this.pcItem_);
                        this.bitField0_ &= -3;
                    }
                    result.pcItem_ = this.pcItem_;
                } else {
                    result.pcItem_ = this.pcItemBuilder_.build();
                }
                if (this.webItemBuilder_ == null) {
                    if ((this.bitField0_ & 0x4) == 4) {
                        this.webItem_ = Collections.unmodifiableList(this.webItem_);
                        this.bitField0_ &= -5;
                    }
                    result.webItem_ = this.webItem_;
                } else {
                    result.webItem_ = this.webItemBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder mergeFrom(Message other) {
                if ((other instanceof ClientMsgProtos.ClientLog)) {
                    return mergeFrom((ClientMsgProtos.ClientLog) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ClientMsgProtos.ClientLog other) {
                if (other == ClientMsgProtos.ClientLog.getDefaultInstance())
                    return this;
                if (other.hasKey()) {
                    setKey(other.getKey());
                }
                if (this.pcItemBuilder_ == null) {
                    if (!other.pcItem_.isEmpty()) {
                        if (this.pcItem_.isEmpty()) {
                            this.pcItem_ = other.pcItem_;
                            this.bitField0_ &= -3;
                        } else {
                            ensurePcItemIsMutable();
                            this.pcItem_.addAll(other.pcItem_);
                        }
                        onChanged();
                    }
                } else if (!other.pcItem_.isEmpty()) {
                    if (this.pcItemBuilder_.isEmpty()) {
                        this.pcItemBuilder_.dispose();
                        this.pcItemBuilder_ = null;
                        this.pcItem_ = other.pcItem_;
                        this.bitField0_ &= -3;
                        this.pcItemBuilder_ = (ClientMsgProtos.ClientLog.alwaysUseFieldBuilders ? getPcItemFieldBuilder() : null);
                    } else {
                        this.pcItemBuilder_.addAllMessages(other.pcItem_);
                    }
                }

                if (this.webItemBuilder_ == null) {
                    if (!other.webItem_.isEmpty()) {
                        if (this.webItem_.isEmpty()) {
                            this.webItem_ = other.webItem_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureWebItemIsMutable();
                            this.webItem_.addAll(other.webItem_);
                        }
                        onChanged();
                    }
                } else if (!other.webItem_.isEmpty()) {
                    if (this.webItemBuilder_.isEmpty()) {
                        this.webItemBuilder_.dispose();
                        this.webItemBuilder_ = null;
                        this.webItem_ = other.webItem_;
                        this.bitField0_ &= -5;
                        this.webItemBuilder_ = (ClientMsgProtos.ClientLog.alwaysUseFieldBuilders ? getWebItemFieldBuilder() : null);
                    } else {
                        this.webItemBuilder_.addAllMessages(other.webItem_);
                    }
                }

                mergeUnknownFields(other.getUnknownFields());
                return this;
            }

            public final boolean isInitialized() {
                if (!hasKey()) {
                    return false;
                }
                for (int i = 0; i < getPcItemCount(); i++) {
                    if (!getPcItem(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i = 0; i < getWebItemCount(); i++) {
                    if (!getWebItem(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ClientMsgProtos.ClientLog parsedMessage = null;
                try {
                    parsedMessage = (ClientMsgProtos.ClientLog) ClientMsgProtos.ClientLog.PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (InvalidProtocolBufferException e) {
                    parsedMessage = (ClientMsgProtos.ClientLog) e.getUnfinishedMessage();
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

            public int getKey() {
                return this.key_;
            }

            public Builder setKey(int value) {
                this.bitField0_ |= 1;
                this.key_ = value;
                onChanged();
                return this;
            }

            public Builder clearKey() {
                this.bitField0_ &= -2;
                this.key_ = 0;
                onChanged();
                return this;
            }

            private void ensurePcItemIsMutable() {
                if ((this.bitField0_ & 0x2) != 2) {
                    this.pcItem_ = new ArrayList(this.pcItem_);
                    this.bitField0_ |= 2;
                }
            }

            public List<PCMsgProto.PCItem> getPcItemList() {
                if (this.pcItemBuilder_ == null) {
                    return Collections.unmodifiableList(this.pcItem_);
                }
                return this.pcItemBuilder_.getMessageList();
            }

            public int getPcItemCount() {
                if (this.pcItemBuilder_ == null) {
                    return this.pcItem_.size();
                }
                return this.pcItemBuilder_.getCount();
            }

            public PCMsgProto.PCItem getPcItem(int index) {
                if (this.pcItemBuilder_ == null) {
                    return (PCMsgProto.PCItem) this.pcItem_.get(index);
                }
                return (PCMsgProto.PCItem) this.pcItemBuilder_.getMessage(index);
            }

            public Builder setPcItem(int index, PCMsgProto.PCItem value) {
                if (this.pcItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensurePcItemIsMutable();
                    this.pcItem_.set(index, value);
                    onChanged();
                } else {
                    this.pcItemBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setPcItem(int index, PCMsgProto.PCItem.Builder builderForValue) {
                if (this.pcItemBuilder_ == null) {
                    ensurePcItemIsMutable();
                    this.pcItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.pcItemBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPcItem(PCMsgProto.PCItem value) {
                if (this.pcItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensurePcItemIsMutable();
                    this.pcItem_.add(value);
                    onChanged();
                } else {
                    this.pcItemBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addPcItem(int index, PCMsgProto.PCItem value) {
                if (this.pcItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensurePcItemIsMutable();
                    this.pcItem_.add(index, value);
                    onChanged();
                } else {
                    this.pcItemBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addPcItem(PCMsgProto.PCItem.Builder builderForValue) {
                if (this.pcItemBuilder_ == null) {
                    ensurePcItemIsMutable();
                    this.pcItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.pcItemBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPcItem(int index, PCMsgProto.PCItem.Builder builderForValue) {
                if (this.pcItemBuilder_ == null) {
                    ensurePcItemIsMutable();
                    this.pcItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.pcItemBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPcItem(Iterable<? extends PCMsgProto.PCItem> values) {
                if (this.pcItemBuilder_ == null) {
                    ensurePcItemIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.pcItem_);
                    onChanged();
                } else {
                    this.pcItemBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPcItem() {
                if (this.pcItemBuilder_ == null) {
                    this.pcItem_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.pcItemBuilder_.clear();
                }
                return this;
            }

            public Builder removePcItem(int index) {
                if (this.pcItemBuilder_ == null) {
                    ensurePcItemIsMutable();
                    this.pcItem_.remove(index);
                    onChanged();
                } else {
                    this.pcItemBuilder_.remove(index);
                }
                return this;
            }

            public PCMsgProto.PCItem.Builder getPcItemBuilder(int index) {
                return (PCMsgProto.PCItem.Builder) getPcItemFieldBuilder().getBuilder(index);
            }

            public PCMsgProto.PCItemOrBuilder getPcItemOrBuilder(int index) {
                if (this.pcItemBuilder_ == null)
                    return (PCMsgProto.PCItemOrBuilder) this.pcItem_.get(index);
                return (PCMsgProto.PCItemOrBuilder) this.pcItemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends PCMsgProto.PCItemOrBuilder> getPcItemOrBuilderList() {
                if (this.pcItemBuilder_ != null) {
                    return this.pcItemBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.pcItem_);
            }

            public PCMsgProto.PCItem.Builder addPcItemBuilder() {
                return (PCMsgProto.PCItem.Builder) getPcItemFieldBuilder().addBuilder(PCMsgProto.PCItem.getDefaultInstance());
            }

            public PCMsgProto.PCItem.Builder addPcItemBuilder(int index) {
                return (PCMsgProto.PCItem.Builder) getPcItemFieldBuilder().addBuilder(index, PCMsgProto.PCItem.getDefaultInstance());
            }

            public List<PCMsgProto.PCItem.Builder> getPcItemBuilderList() {
                return getPcItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<PCMsgProto.PCItem, PCMsgProto.PCItem.Builder, PCMsgProto.PCItemOrBuilder> getPcItemFieldBuilder() {
                if (this.pcItemBuilder_ == null) {
                    this.pcItemBuilder_ = new RepeatedFieldBuilder(this.pcItem_, (this.bitField0_ & 0x2) == 2, getParentForChildren(), isClean());
                    this.pcItem_ = null;
                }
                return this.pcItemBuilder_;
            }

            private void ensureWebItemIsMutable() {
                if ((this.bitField0_ & 0x4) != 4) {
                    this.webItem_ = new ArrayList(this.webItem_);
                    this.bitField0_ |= 4;
                }
            }

            public List<WebMsgProto.WebItem> getWebItemList() {
                if (this.webItemBuilder_ == null) {
                    return Collections.unmodifiableList(this.webItem_);
                }
                return this.webItemBuilder_.getMessageList();
            }

            public int getWebItemCount() {
                if (this.webItemBuilder_ == null) {
                    return this.webItem_.size();
                }
                return this.webItemBuilder_.getCount();
            }

            public WebMsgProto.WebItem getWebItem(int index) {
                if (this.webItemBuilder_ == null) {
                    return (WebMsgProto.WebItem) this.webItem_.get(index);
                }
                return (WebMsgProto.WebItem) this.webItemBuilder_.getMessage(index);
            }

            public Builder setWebItem(int index, WebMsgProto.WebItem value) {
                if (this.webItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureWebItemIsMutable();
                    this.webItem_.set(index, value);
                    onChanged();
                } else {
                    this.webItemBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setWebItem(int index, WebMsgProto.WebItem.Builder builderForValue) {
                if (this.webItemBuilder_ == null) {
                    ensureWebItemIsMutable();
                    this.webItem_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.webItemBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addWebItem(WebMsgProto.WebItem value) {
                if (this.webItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureWebItemIsMutable();
                    this.webItem_.add(value);
                    onChanged();
                } else {
                    this.webItemBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addWebItem(int index, WebMsgProto.WebItem value) {
                if (this.webItemBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureWebItemIsMutable();
                    this.webItem_.add(index, value);
                    onChanged();
                } else {
                    this.webItemBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addWebItem(WebMsgProto.WebItem.Builder builderForValue) {
                if (this.webItemBuilder_ == null) {
                    ensureWebItemIsMutable();
                    this.webItem_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.webItemBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addWebItem(int index, WebMsgProto.WebItem.Builder builderForValue) {
                if (this.webItemBuilder_ == null) {
                    ensureWebItemIsMutable();
                    this.webItem_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.webItemBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllWebItem(Iterable<? extends WebMsgProto.WebItem> values) {
                if (this.webItemBuilder_ == null) {
                    ensureWebItemIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.webItem_);
                    onChanged();
                } else {
                    this.webItemBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearWebItem() {
                if (this.webItemBuilder_ == null) {
                    this.webItem_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.webItemBuilder_.clear();
                }
                return this;
            }

            public Builder removeWebItem(int index) {
                if (this.webItemBuilder_ == null) {
                    ensureWebItemIsMutable();
                    this.webItem_.remove(index);
                    onChanged();
                } else {
                    this.webItemBuilder_.remove(index);
                }
                return this;
            }

            public WebMsgProto.WebItem.Builder getWebItemBuilder(int index) {
                return (WebMsgProto.WebItem.Builder) getWebItemFieldBuilder().getBuilder(index);
            }

            public WebMsgProto.WebItemOrBuilder getWebItemOrBuilder(int index) {
                if (this.webItemBuilder_ == null)
                    return (WebMsgProto.WebItemOrBuilder) this.webItem_.get(index);
                return (WebMsgProto.WebItemOrBuilder) this.webItemBuilder_.getMessageOrBuilder(index);
            }

            public List<? extends WebMsgProto.WebItemOrBuilder> getWebItemOrBuilderList() {
                if (this.webItemBuilder_ != null) {
                    return this.webItemBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.webItem_);
            }

            public WebMsgProto.WebItem.Builder addWebItemBuilder() {
                return (WebMsgProto.WebItem.Builder) getWebItemFieldBuilder().addBuilder(WebMsgProto.WebItem.getDefaultInstance());
            }

            public WebMsgProto.WebItem.Builder addWebItemBuilder(int index) {
                return (WebMsgProto.WebItem.Builder) getWebItemFieldBuilder().addBuilder(index, WebMsgProto.WebItem.getDefaultInstance());
            }

            public List<WebMsgProto.WebItem.Builder> getWebItemBuilderList() {
                return getWebItemFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<WebMsgProto.WebItem, WebMsgProto.WebItem.Builder, WebMsgProto.WebItemOrBuilder> getWebItemFieldBuilder() {
                if (this.webItemBuilder_ == null) {
                    this.webItemBuilder_ = new RepeatedFieldBuilder(this.webItem_, (this.bitField0_ & 0x4) == 4, getParentForChildren(), isClean());
                    this.webItem_ = null;
                }
                return this.webItemBuilder_;
            }
        }
    }

    public static abstract interface ClientLogOrBuilder extends MessageOrBuilder {
        public abstract boolean hasKey();

        public abstract int getKey();

        public abstract List<PCMsgProto.PCItem> getPcItemList();

        public abstract PCMsgProto.PCItem getPcItem(int paramInt);

        public abstract int getPcItemCount();

        public abstract List<? extends PCMsgProto.PCItemOrBuilder> getPcItemOrBuilderList();

        public abstract PCMsgProto.PCItemOrBuilder getPcItemOrBuilder(int paramInt);

        public abstract List<WebMsgProto.WebItem> getWebItemList();

        public abstract WebMsgProto.WebItem getWebItem(int paramInt);

        public abstract int getWebItemCount();

        public abstract List<? extends WebMsgProto.WebItemOrBuilder> getWebItemOrBuilderList();

        public abstract WebMsgProto.WebItemOrBuilder getWebItemOrBuilder(int paramInt);
    }
}