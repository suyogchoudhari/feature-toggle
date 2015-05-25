<%@include file="/libs/foundation/global.jsp"%>

<script>
    var FEATURE_LIST = '<%= com.forwardslash.featuretoggle.Utils.getConfigService().getFeaturesList() %>';
</script>

<cq:includeClientLib js="cl.forwardslash.featuretoggle" />

