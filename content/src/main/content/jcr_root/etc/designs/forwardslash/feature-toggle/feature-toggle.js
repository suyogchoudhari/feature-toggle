/**
 * developed by forwardslash (forward slash)
 */

if (typeof ForwardSlash === "undefined") {
  var ForwardSlash = {};
}

// FEATURE_LIST is initialized on feature-toggle component jsp
ForwardSlash.FeatureToggle = {
  isAvailable: function(featureName) {
    //feature toggle function
	  if(FEATURE_LIST!=null && (FEATURE_LIST.indexOf(featureName) > -1) ){
  		return true;
  	} else {
  		return false;
  	}
  }
};