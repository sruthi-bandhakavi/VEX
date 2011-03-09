// Global Object
/*var Global = 
	{
		"@Prototype":  Global,
		"@Class":      Global,
		"@this":	Global,
        "@Scope":	null,
        Array: 		Array
     }*/
     
  

var __callFun__ = function(a){
//This is a dummy function, which parses the string in the argument "a" 
// And calls it

// Implemented in the parser
// To be used by several functions like setTimeout, eval, XMLHTTPRequest

  /*this.___callFun = function(a){
  }*/
}

var eval = function(str){
}

var addEventListener = function(a,b,c){
        b();
}

var setTimeout = function(a,b){
    //var cf = new __callFun__();
    //cf.___callFun(a);
    __callFun__(a);
}

/* JavaScript Core Library */     
var Date = function(){
     this.at_Class = "Object";
     this.prototype = ObjectProt;
     this.__proto__ =  ObjectProt;
     this.now = new function(){return 0;};
     this.parse = new function(x){return x;};
     this.
}

var Object = function(){
     this.at_Class = "Object";
     this.prototype = FunctionProt;
     this.__proto__ =  ObjectProt;
}

var Array = function(){
	   this.at_Class = "Function";
	   this.prototype = ArrayProt;
	   this.__proto__ =  FunctionProt;
};
          

var ArrayProt = {
	 at_Class:        "Array",
	 __proto__ :    ObjectProt,
     __length__:      0,	
     __constructor__: Array,
	 toString:    null,
	 push : function(arg){
	 			//this[this.length] = arg;
	 			//this.length = this.length+1;
	          }
 };

var FunctionProt = {};
var ObjectProt = {};

var gBrowser = {
  mCurrentBrowser: {}
}
		
/* DOM Functions*/
var window = {
	content : {
		document : {}
	},
    document: {
        popupNode : {},
        /*getElementById : function(x){
            return this;
        }*/
    },
    parent: {
    },    
}
window._content = window.content;
document = window.document;
content = window.content;


/* Components API */	
var Components = {
	toString : null,
	classes : {
        "@mozilla.org/feed-processor;1" : {
			getService : function(x){
				return x;
			},
            createInstance : function(x){
                return new x();
            }

		},

		"@mozilla.org/rdf/rdf-service;1" : {
			getService : function(x){
				return x;
			},
            createInstance : function(x){
                return new x();
            }

		},
        "@mozilla.org/preferences-service;1" : {
            getService : function(x){
				return x;
			},
            createInstance : function(x){
                return new x();
            }

        },
        "@mozilla.org/browser/livemark-service;2" : {
            getService : function(x){
				return x;
			},
            createInstance : function(x){
                return new x();
            }

        },
        "@mozilla.org/browser/nav-bookmarks-service;1" : {
            getService : function(x){
				return x;
			},
            createInstance : function(x){
                return new x();
            }

        },
        "@mozilla.org/browser/annotation-service;1" : {
            getService : function(x){
				return x;
			},
            createInstance : function(x){
                return new x();
            }

        },
		"rdf-service1" : {
			getService : function(x){
				return x;
			},
            createInstance : function(x){
                return new x();
            }

		},
        "@mozilla.org/network/file-output-stream;1" : {
            getService : function(x){
				return x;
			},
            createInstance : function(x){
                return new x();
            }
            
        }
	},
    
	interfaces: {
        nsIFeedProcessor : function() {
            this.interfaceName = "nsIFeedProcessor",
            this.listener = null,
            this.parseFromString = function(str,uri){
                this.listener.handleResult({doc:str, uri: uri});
            }
        },

		nsIRDFService : {
            interfaceName : "nsIRDFService",
        },

		nsIRDFService_low : {
            interfaceName : "nsIRDFService_low",
        },

        nsIPrefBranch : {
            interfaceName : "nsIPrefBranch",
        },
        
        nsIPrefService : {
            interfaceName : "nsIPrefService",
        },


        nsINavBookmarksService : {
            interfaceName : "nsINavBookmarksService",
        },

        nsILivemarkService : {
            interfaceName : "nsILivemarkService",
        },
        nsIAnnotationService : {
            interfaceName : "nsIAnnotationService",
        },
        nsIFileOutputStream: function(){
            this.interfaceName = "nsIFileOutputStream";
        }
	}
};  

/*Components.classes['@mozilla.org/network/file-output-stream;1']
						.createInstance(Components.interfaces.nsIFileOutputStream);
		stream.init(tmpFile, 2, 0x200, false); // open as "write only"
		
		var content = this.createHTMLSource(feed);*/

var RDF = Components.classes["@mozilla.org/rdf/rdf-service;1"];
var BookmarksUtils = {};


// DOM

/*
* XMLHTTPRequest
*/
var XMLHttpRequest = function(){

 this.onload = null;
 this.onerror = null;
 this.callback = null;
 this.onreadystatechange = null;
 this.responseXML = null;
 this.open = null;
 this.send = function(){
    this.onreadystatechange();
    this.onload();
    this.callback();
 }
}


