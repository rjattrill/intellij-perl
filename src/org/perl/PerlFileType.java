package org.perl;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.encoding.EncodingManager;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.nio.charset.Charset;

public class PerlFileType extends LanguageFileType {
	public static final LanguageFileType INSTANCE = new PropertiesFileType();
	@NonNls public static final String DEFAULT_EXTENSION = "properties";
	@NonNls public static final String DOT_DEFAULT_EXTENSION = "."+DEFAULT_EXTENSION;

	private PropertiesFileType() {
		super(PropertiesLanguage.INSTANCE);
	}

	@Override
	@NotNull
	public String getName() {
		return "Properties";
	}

	@Override
	@NotNull
	public String getDescription() {
		return PropertiesBundle.message("properties.files.file.type.description");
	}

	@Override
	@NotNull
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public Icon getIcon() {
		return AllIcons.FileTypes.Properties;
	}

	@Override
	public String getCharset(@NotNull VirtualFile file, final byte[] content) {
		Charset charset = EncodingManager.getInstance().getDefaultCharsetForPropertiesFiles(file);
		return charset == null ? CharsetToolkit.getDefaultSystemCharset().name() : charset.name();
	}
}
