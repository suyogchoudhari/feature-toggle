/**
 * developed by forwardslash (forward slash)
 */


ForwardSlash.FeatureToggle = {
  isLive: function(featureName) {
    //feature toggle function
	  if(FEATURE_LIST!=null && (FEATURE_LIST.indexOf(featureName) > -1) ){
  		return true;
  	} else {
  		return false;
  	}
  }
};