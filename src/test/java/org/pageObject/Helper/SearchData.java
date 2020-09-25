package org.pageObject.Helper;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SearchData {
    String searchInput;
    String resultDomain;
}
