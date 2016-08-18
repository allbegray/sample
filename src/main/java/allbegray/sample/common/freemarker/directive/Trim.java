package allbegray.sample.common.freemarker.directive;

import java.util.List;

/**
 * Created by allbegray on 2016-08-19.
 */
public class Trim {

    private String prefix;
    private String suffix;
    private List<String> prefixesToOverride;
    private List<String> suffixesToOverride;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public List<String> getPrefixesToOverride() {
        return prefixesToOverride;
    }

    public void setPrefixesToOverride(List<String> prefixesToOverride) {
        this.prefixesToOverride = prefixesToOverride;
    }

    public List<String> getSuffixesToOverride() {
        return suffixesToOverride;
    }

    public void setSuffixesToOverride(List<String> suffixesToOverride) {
        this.suffixesToOverride = suffixesToOverride;
    }

    public String trim(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sqlBuffer = new StringBuilder(s.trim());
        String trimmedUppercaseSql = sqlBuffer.toString().toUpperCase();
        if (trimmedUppercaseSql.length() > 0) {
            applyPrefix(sqlBuffer, trimmedUppercaseSql);
            applySuffix(sqlBuffer, trimmedUppercaseSql);
        }
        return sqlBuffer.toString();
    }

    private void applyPrefix(StringBuilder sqlBuffer, String trimmedUppercaseSql) {
        if (prefixesToOverride != null) {
            for (String p : prefixesToOverride) {
                if (trimmedUppercaseSql.startsWith(p)) {
                    sqlBuffer.delete(0, p.trim().length());
                    break;
                }
            }
        }
        if (prefix != null) {
            sqlBuffer.insert(0, " ");
            sqlBuffer.insert(0, prefix);
        }
    }

    private void applySuffix(StringBuilder sqlBuffer, String trimmedUppercaseSql) {
        if (suffixesToOverride != null) {
            for (String s : suffixesToOverride) {
                if (trimmedUppercaseSql.endsWith(s) || trimmedUppercaseSql.endsWith(s.trim())) {
                    int start = sqlBuffer.length() - s.trim().length();
                    int end = sqlBuffer.length();
                    sqlBuffer.delete(start, end);
                    break;
                }
            }
        }
        if (suffix != null) {
            sqlBuffer.append(" ");
            sqlBuffer.append(suffix);
        }
    }

}
