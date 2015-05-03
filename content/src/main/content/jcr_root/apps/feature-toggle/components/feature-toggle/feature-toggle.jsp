<script>
    var FEATURE_LIST : '<%= com.forwardslash.featuretoggle.Utils.getConfigService().getFeaturesList() %>'
</script>

<%-- only js libs --%>

<cq:include path="par" resourceType="/apps/feature-toggle/components/feature-toggle"/>

<cq:includeClientLib js="eb.publish.featuretoggle" />

