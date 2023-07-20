function demo(){var mb='',nb=0,ob='gwt.codesvr=',pb='gwt.hosted=',qb='gwt.hybrid',rb='demo',sb='__gwt_marker_demo',tb='script',ub='SCRIPT',vb='#',wb='?',xb='/',yb=1,zb='base',Ab='img',Bb='clear.cache.gif',Cb='meta',Db='name',Eb='gwt:property',Fb='content',Gb='=',Hb='gwt:onPropertyErrorFn',Ib='Bad handler "',Jb='" for "gwt:onPropertyErrorFn"',Kb='gwt:onLoadErrorFn',Lb='" for "gwt:onLoadErrorFn"',Mb='Single-script hosted mode not yet implemented. See issue ',Nb='http://code.google.com/p/google-web-toolkit/issues/detail?id=2079',Ob='B1914551C6ED2A64267E70B37ED28214',Pb=':',Qb='DOMContentLoaded',Rb=50;var k=mb,l=nb,m=ob,n=pb,o=qb,p=rb,q=sb,r=tb,s=ub,t=vb,u=wb,v=xb,w=yb,A=zb,B=Ab,C=Bb,D=Cb,F=Db,G=Eb,H=Fb,I=Gb,J=Hb,K=Ib,L=Jb,M=Kb,N=Lb,O=Mb,P=Nb,Q=Ob,R=Pb,S=Qb,T=Rb;var U=window,V=document,W,X,Y=k,Z={},$=[],_=[],ab=[],bb=l,cb,db;if(!U.__gwt_stylesLoaded){U.__gwt_stylesLoaded={}}if(!U.__gwt_scriptsLoaded){U.__gwt_scriptsLoaded={}}function eb(){var b=false;try{var c=U.location.search;return (c.indexOf(m)!=-1||(c.indexOf(n)!=-1||U.external&&U.external.gwtOnLoad))&&c.indexOf(o)==-1}catch(a){}eb=function(){return b};return b}
function fb(){if(W&&X){W(cb,p,Y,bb)}}
function gb(){var e,f=q,g;g=V.createElement(r);g.id=f;V.body.appendChild(g);e=g&&g.previousSibling;while(e&&e.tagName!=s){e=e.previousSibling}function h(a){var b=a.lastIndexOf(t);if(b==-1){b=a.length}var c=a.indexOf(u);if(c==-1){c=a.length}var d=a.lastIndexOf(v,Math.min(c,b));return d>=l?a.substring(l,d+w):k}
;if(e&&e.src){Y=h(e.src)}if(Y==k){var i=V.getElementsByTagName(A);if(i.length>l){Y=i[i.length-w].href}else{Y=h(V.location.href)}}else if(Y.match(/^\w+:\/\//)){}else{var j=V.createElement(B);j.src=Y+C;Y=h(j.src)}if(g){g.parentNode.removeChild(g)}}
function hb(){var b=document.getElementsByTagName(D);for(var c=l,d=b.length;c<d;++c){var e=b[c],f=e.getAttribute(F),g;if(f){if(f==G){g=e.getAttribute(H);if(g){var h,i=g.indexOf(I);if(i>=l){f=g.substring(l,i);h=g.substring(i+w)}else{f=g;h=k}Z[f]=h}}else if(f==J){g=e.getAttribute(H);if(g){try{db=eval(g)}catch(a){alert(K+g+L)}}}else if(f==M){g=e.getAttribute(H);if(g){try{cb=eval(g)}catch(a){alert(K+g+N)}}}}}}
__gwt_isKnownPropertyValue=function(a,b){return b in $[a]};__gwt_getMetaProperty=function(a){var b=Z[a];return b==null?null:b};demo.onScriptLoad=function(a){demo=null;W=a;fb()};if(eb()){alert(O+P);return}gb();hb();try{var ib;ib=Q;var jb=ib.indexOf(R);if(jb!=-1){bb=Number(ib.substring(jb+w))}}catch(a){return}var kb;function lb(){if(!X){X=true;fb();if(V.removeEventListener){V.removeEventListener(S,lb,false)}if(kb){clearInterval(kb)}}}
if(V.addEventListener){V.addEventListener(S,function(){lb()},false)}var kb=setInterval(function(){if(/loaded|complete/.test(V.readyState)){lb()}},T)}
demo();(function () {var $gwt_version = "2.10.0";var $wnd = window;var $doc = $wnd.document;var $moduleName, $moduleBase;var $stats = $wnd.__gwtStatsEvent ? function(a) {$wnd.__gwtStatsEvent(a)} : null;var $strongName = 'B1914551C6ED2A64267E70B37ED28214';function k(){}
function Y(){}
function sc(){}
function oc(){}
function fb(){}
function ib(){}
function wd(){}
function Mc(){Mc=oc}
function F(){F=oc;D=new k}
function V(){V=oc;U=new Y}
function L(){L=oc;!!(bb(),ab)}
function pd(a){C.call(this,a)}
function ud(a){B.call(this,a)}
function hd(){B.call(this,null)}
function od(){n(this);this.q()}
function Fc(a,b){this.a=a;this.b=b}
function jb(a,b){return $c(a,b)}
function Dd(a){return a>>>0}
function yd(){return ++vd}
function Sc(a){Rc(a);return a.j}
function cb(a){bb();ab.s(a)}
function T(){I!=0&&(I=0);K=-1}
function jc(){hc==null&&(hc=[])}
function md(a){return Ab((Ad(a),a))}
function nd(a){return rd(Gd,typeof(a))}
function td(a){return rd(Hd,typeof(a))}
function vb(a){return typeof a===Fd}
function wb(a){return typeof a===Gd}
function yb(a){return typeof a===Hd}
function zb(a){return a==null?null:a}
function ub(a,b){return a!=null&&rb(a,b)}
function zd(a){return a.$H||(a.$H=++vd)}
function gc(a){return a.backingJsObject}
function Nc(a){return (Ad(a),a)?1231:1237}
function rd(a,b){return Ad(a),zb(a)===zb(b)}
function M(a,b,c){return a.apply(b,c);var d}
function xb(a,b){return a&&b&&a instanceof b}
function Oc(a){Mc();return rd(Fd,typeof(a))}
function Cd(a){if(!a){throw gc(new hd)}}
function Rc(a){if(a.j!=null){return}cd(a)}
function S(a){$wnd.clearTimeout(a)}
function B(a){this.c=a;n(this);this.q()}
function Ic(a,b){this.b=b;this.c=a;n(this);this.q()}
function G(a){F();C.call(this,a);this.a=a}
function p(a,b){a.backingJsObject=b;o(a,b)}
function n(a){a.e&&a.backingJsObject!==Jd&&a.q();return a}
function Z(a,b){!a&&(a=[]);a[a.length]=b;return a}
function sb(a,b){Cd(a==null||rb(a,b));return a}
function Ad(a){if(a==null){throw gc(new od)}return a}
function Wc(a,b,c){var d;d=Vc(a,b);gd(c,d);return d}
function Yc(a,b){var c;c=Vc('',a);c.i=b;c.f=1;return c}
function Vc(a,b){var c;c=new Tc;c.g=a;c.d=b;return c}
function q(a,b){var c;c=Sc(a.C);return b==null?c:c+': '+b}
function $c(a,b){var c=a.a=a.a||[];return c[b]||(c[b]=a.t(b))}
function Hc(){var a;a=Kc();if(!rd(Qd,a)){throw gc(new Jc(a))}}
function bb(){bb=oc;var a,b;b=!eb();a=new ib;ab=b?new fb:a}
function mb(a){return Array.isArray(a)&&a.F===sc}
function tb(a){return !Array.isArray(a)&&a.F===sc}
function ad(a){if(a.B()){return null}var b=a.i;return mc[b]}
function pc(a){function b(){}
;b.prototype=a||{};return new b}
function s(b){if(!('stack' in b)){try{throw b}catch(a){}}return b}
function R(a){L();$wnd.setTimeout(function(){throw a},0)}
function Q(a){a&&X((V(),U));--I;if(a){if(K!=-1){S(K);K=-1}}}
function Gc(){Ec();return nb(jb(Lb,1),{3:1},14,0,[Bc,Cc,Dc])}
function O(b){L();return function(){return P(b,this,arguments);var a}}
function P(a,b,c){var d;d=N();try{return M(a,b,c)}finally{Q(d)}}
function Xc(a,b,c,d){var e;e=Vc(a,b);gd(c,e);e.f=d?8:0;return e}
function kb(a,b,c,d,e,f){var g;g=lb(e,d);e!=10&&nb(jb(a,f),b,c,e,g);return g}
function gd(a,b){var c;if(!a){return}b.i=a;var d=ad(b);if(!d){mc[a]=[b];return}d.C=b}
function W(a){var b,c;if(a.a){c=null;do{b=a.a;a.a=null;c=$(b,c)}while(a.a);a.a=c}}
function X(a){var b,c;if(a.b){c=null;do{b=a.b;a.b=null;c=$(b,c)}while(a.b);a.b=c}}
function Bd(a,b){if(a<0||a>=b){throw gc(new ud('Index: '+a+', Size: '+b))}}
function ld(a){return rd(Gd,typeof(a))||xb(a,$wnd.java.lang.Number$impl)}
function Ab(a){return Math.max(Math.min(a,2147483647),-2147483648)|0}
function C(a){n(this);this.backingJsObject=a;o(this,a);this.c=a==null?'null':rc(a)}
function tc(){$wnd.setTimeout(Ed(Hc));uc();$wnd.goog.global.alert('Hello, world!')}
function Ec(){Ec=oc;Bc=new Fc('ERROR',0);Cc=new Fc('IGNORE',1);Dc=new Fc('WARN',2)}
function ic(){jc();var a=hc;for(var b=0;b<arguments.length;b++){a.push(arguments[b])}}
function fc(a){var b;if(ub(a,4)){return a}b=a&&a.__java$exception;if(!b){b=new G(a);cb(b)}return b}
function A(a){var b;if(a!=null){b=a.__java$exception;if(b){return b}}return xb(a,TypeError)?new pd(a):new C(a)}
function jd(a){if(a==null){return false}return a.$implements__java_lang_Cloneable||Array.isArray(a)}
function Pc(a){if(rd(typeof(a),Hd)){return true}return a!=null&&a.$implements__java_lang_CharSequence}
function kd(a){var b;b=typeof(a);if(rd(b,Fd)||rd(b,Gd)||rd(b,Hd)){return true}return a!=null&&a.$implements__java_lang_Comparable}
function xd(a){switch(typeof(a)){case Hd:return sd(a);case Gd:return md(a);case Fd:return Nc(a);default:return a==null?0:zd(a);}}
function db(a){var b=/function(?:\s+([\w$]+))?\s*\(/;var c=b.exec(a);return c&&c[1]||'anonymous'}
function sd(a){var b,c;b=0;for(c=0;c<a.length;c++){b=(b<<5)-b+(Bd(c,a.length),a.charCodeAt(c))|0}return b}
function nb(a,b,c,d,e){e.C=a;e.D=b;e.F=sc;e.__elementTypeId$=c;e.__elementTypeCategory$=d;return e}
function lc(a,b){typeof window==='object'&&typeof window['$gwt']==='object'&&(window['$gwt'][a]=b)}
function Tc(){++Qc;this.j=null;this.h=null;this.g=null;this.d=null;this.b=null;this.i=null;this.a=null}
function Jc(a){Ic.call(this,Rd+a+Sd+Td==null?'null':rc(Rd+a+Sd+Td),ub(Rd+a+Sd+Td,4)?sb(Rd+a+Sd+Td,4):null)}
function N(){var a;if(I!=0){a=Date.now();if(a-J>2000){J=a;K=$wnd.setTimeout(T,10)}}if(I++==0){W((V(),U));return true}return false}
function eb(){if(Error.stackTraceLimit>0){$wnd.Error.stackTraceLimit=Error.stackTraceLimit=64;return true}return 'stack' in new Error}
function fd(a,b){var c=0;while(!b[c]||b[c]==''){c++}var d=b[c++];for(;c<b.length;c++){if(!b[c]||b[c]==''){continue}d+=a+b[c]}return d}
function rb(a,b){if(yb(a)){return !!qb[b]}else if(a.D){return !!a.D[b]}else if(wb(a)){return !!pb[b]}else if(vb(a)){return !!ob[b]}return false}
function Lc(a){var b;if(a==null){return false}b=typeof(a);return rd(b,Fd)||rd(b,Gd)||rd(b,Hd)||a.$implements__java_io_Serializable||Array.isArray(a)}
function lb(a,b){var c=new Array(b);var d;switch(a){case 14:case 15:d=0;break;case 16:d=false;break;default:return c;}for(var e=0;e<b;++e){c[e]=d}return c}
function kc(b,c,d,e){jc();var f=hc;$moduleName=c;$moduleBase=d;ec=e;function g(){for(var a=0;a<f.length;a++){f[a]()}}
if(b){try{Ed(g)()}catch(a){b(c,a)}}else{Ed(g)()}}
function $(b,c){var d,e,f,g;for(e=0,f=b.length;e<f;e++){g=b[e];try{g[1]?g[0].G()&&(c=Z(c,g)):g[0].G()}catch(a){a=fc(a);if(ub(a,4)){d=a;L();R(ub(d,10)?sb(d,10).r():d)}else throw gc(a)}}return c}
function Kc(){var a=navigator.userAgent.toLowerCase();var b=$doc.documentMode;if(function(){return a.indexOf('webkit')!=-1}())return Qd;if(function(){return a.indexOf('gecko')!=-1||b>=11}())return 'gecko1_8';return 'unknown'}
function qc(a,b){var c=$wnd;if(a===''){return c}var d=a.split('.');!(d[0] in c)&&c.execScript&&c.execScript('var '+d[0]);if(b){var e=b.prototype.C;e.e=b}for(var f;d.length&&(f=d.shift());){c=c[f]=c[f]||!d.length&&b||{}}return c}
function nc(a,b,c){var d=mc,h;var e=d[a];var f=e instanceof Array?e[0]:null;if(e&&!f){_=e}else{_=(h=b&&b.prototype,!h&&(h=mc[b]),pc(h));_.D=c;!b&&(_.F=sc);d[a]=_}for(var g=3;g<arguments.length;++g){arguments[g].prototype=_}f&&(_.C=f)}
function cd(a){if(a.A()){var b=a.c;b.B()?(a.j='['+b.i):!b.A()?(a.j='[L'+b.v()+';'):(a.j='['+b.v());a.b=b.u()+'[]';a.h=b.w()+'[]';return}var c=a.g;var d=a.d;d=d.split('/');a.j=fd('.',[c,fd('$',d)]);a.b=fd('.',[c,fd('.',d)]);a.h=d[d.length-1]}
function rc(a){var b;if(Array.isArray(a)&&a.F===sc){return Sc(yb(a)?ac:wb(a)?Rb:vb(a)?Ob:tb(a)?a.C:mb(a)?a.C:a.C||Array.isArray(a)&&jb(Db,1)||Db)+'@'+(b=(yb(a)?sd(a):wb(a)?md(a):vb(a)?Nc(a):tb(a)?a.l():mb(a)?zd(a):!!a&&!!a.hashCode?a.hashCode():zd(a))>>>0,b.toString(16))}return a.toString()}
function o(d,b){if(b instanceof Object){try{b.__java$exception=d;if(navigator.userAgent.toLowerCase().indexOf('msie')!=-1&&$doc.documentMode<9){return}var c=d;Object.defineProperties(b,{cause:{get:function(){var a=c.p();return a&&a.n()}},suppressed:{get:function(){return c.o()}}})}catch(a){}}}
function uc(){var a,b,c,d,e;e=(Ec(),Dc);if(e==Cc){return}b=$doc.compatMode;a=nb(jb(ac,1),{3:1},2,6,[Pd]);for(c=0;c<a.length;c++){if(rd(a[c],b)){return}}a.length==1&&rd(Pd,a[0])&&rd('BackCompat',b)?(d="GWT no longer supports Quirks Mode (document.compatMode=' BackCompat').<br>Make sure your application's host HTML page has a Standards Mode (document.compatMode=' CSS1Compat') doctype,<br>e.g. by using &lt;!doctype html&gt; at the start of your application's HTML page.<br><br>To continue using this unsupported rendering mode and risk layout problems, suppress this message by adding<br>the following line to your*.gwt.xml module file:<br>&nbsp;&nbsp;&lt;extend-configuration-property name=\"document.compatMode\" value=\""+b+'"/&gt;'):(d="Your *.gwt.xml module configuration prohibits the use of the current document rendering mode (document.compatMode=' "+b+"').<br>Modify your application's host HTML page doctype, or update your custom "+"'document.compatMode' configuration property settings.");if(e==Bc){throw gc(new B(d))}}
var Fd='boolean',Gd='number',Hd='string',Id={3:1,16:1},Jd='__noinit__',Kd={3:1,4:1},Ld='java.lang',Md='com.google.gwt.core.client',Nd='com.google.gwt.core.client.impl',Od='javaemul.internal',Pd='CSS1Compat',Qd='safari',Rd='Possible problem with your *.gwt.xml module file.\nThe compile time user.agent value (safari) does not match the runtime user.agent value (',Sd=').\n',Td='Expect more errors.';var _,mc,hc,ec=-1;$wnd.goog=$wnd.goog||{};$wnd.goog.global=$wnd.goog.global||$wnd;mc={};nc(1,null,{},k);_.k=function l(){return this.C};_.l=function m(){return zd(this)};_.hashCode=function(){return this.l()};var ab;nc(49,1,{});nc(25,49,{},fb);_.s=function gb(a){var b={},j;var c=[];a['fnStack']=c;var d=arguments.callee.caller;while(d){var e=(bb(),d.name||(d.name=db(d.toString())));c.push(e);var f=':'+e;var g=b[f];if(g){var h,i;for(h=0,i=g.length;h<i;h++){if(g[h]===d){return}}}(g||(b[f]=[])).push(d);d=d.caller}};nc(50,49,{});_.s=function hb(a){};nc(26,50,{},ib);var ob,pb,qb;ob=Id;nc(21,1,{},Tc);_.t=function Uc(a){var b;b=new Tc;b.f=4;a>1?(b.c=$c(this,a-1)):(b.c=this);return b};_.u=function Zc(){Rc(this);return this.b};_.v=function _c(){return Sc(this)};_.w=function bd(){Rc(this);return this.h};_.A=function dd(){return (this.f&4)!=0};_.B=function ed(){return (this.f&1)!=0};_.f=0;var Qc=1;nc(45,1,{3:1});pb=Id;nc(4,1,Kd);_.m=function r(a){return new Error(a)};_.n=function t(){return this.backingJsObject};_.o=function u(){var a,b,c;c=(this.d==null&&(this.d=kb(bc,{3:1},4,0,0,1)),this.d);b=kb(Zb,{3:1},1,c.length,5,1);for(a=0;a<c.length;a++){b[a]=c[a].backingJsObject}return b};_.p=function v(){return this.b};_.q=function w(){p(this,s(this.m(q(this,this.c))));cb(this)};_.backingJsObject=Jd;_.e=true;nc(17,4,Kd);nc(8,17,Kd,B);nc(28,8,Kd);nc(13,8,Kd,C);nc(20,13,Kd,od,pd);_.m=function qd(a){return new TypeError(a)};qb={3:1,54:1,16:1,2:1};nc(29,28,Kd,ud);nc(86,1,{});nc(47,1,{},wd);var vd=0;nc(48,1,{});var Zb=Wc(Ld,'Object',1);var Db=Wc(Md,'JavaScriptObject$',0);var Kb=Wc(Nd,'StackTraceCreator/Collector',49);var Hb=Wc(Nd,'StackTraceCreator/CollectorLegacy',25);var Jb=Wc(Nd,'StackTraceCreator/CollectorModern',50);var Ib=Wc(Nd,'StackTraceCreator/CollectorModernNoSourceMap',26);var Ob=Wc(Ld,'Boolean',44);var Qb=Wc(Ld,'Class',21);var Yb=Wc(Ld,'Number',45);var Rb=Wc(Ld,'Double',46);var bc=Wc(Ld,'Throwable',4);var Ub=Wc(Ld,'Exception',17);var $b=Wc(Ld,'RuntimeException',8);var Vb=Wc(Ld,'IndexOutOfBoundsException',28);var Wb=Wc(Ld,'JsException',13);var Xb=Wc(Ld,'NullPointerException',20);var ac=Wc(Ld,'String',2);var _b=Wc(Ld,'StringIndexOutOfBoundsException',29);var cc=Wc(Od,'HashCodes',47);var dc=Wc(Od,'JsUtils',48);nc(27,13,Kd);var Fb=Wc(Nd,'JavaScriptExceptionBase',27);nc(10,27,{10:1,3:1,4:1},G);_.r=function H(){return zb(this.a)===zb(D)?null:this.a};var D;var Cb=Wc(Md,'JavaScriptException',10);nc(34,1,{});var Eb=Wc(Md,'Scheduler',34);var I=0,J=0,K=-1;nc(32,34,{},Y);var U;var Gb=Wc(Nd,'SchedulerImpl',32);nc(23,1,Id);_.compareTo=function vc(a){return this.b-a.b};_.equals=function wc(a){return this===a};_.hashCode=function xc(){return zd(this)};_.l=function(){return this.hashCode()};_.name=function yc(){return this.a!=null?this.a:''+this.b};_.ordinal=function zc(){return this.b};_.toString=function Ac(){return this.a!=null?this.a:''+this.b};_.b=0;var Sb=Wc(Ld,'Enum',23);nc(14,23,Id,Fc);var Bc,Cc,Dc;var Lb=Xc('com.google.gwt.user.client','DocumentModeAsserter/Severity',14,Gc);nc(15,4,Kd);var Tb=Wc(Ld,'Error',15);nc(6,15,Kd);var Nb=Wc(Ld,'AssertionError',6);nc(22,6,Kd,Jc);var Mb=Wc('com.google.gwt.useragent.client','UserAgentAsserter/UserAgentAssertionError',22);nc(24,8,Kd,hd);var Pb=Wc(Ld,'ClassCastException',24);nc(90,1,{});nc(92,1,{});nc(689,1,{});var Bb=Yc('double','D');_=qc('java.io.Serializable');_.$isInstance=Lc;Mc();_=qc('java.lang.Boolean');_.$isInstance=Oc;_=qc('java.lang.CharSequence');_.$isInstance=Pc;_=qc('java.lang.Cloneable');_.$isInstance=jd;_=qc('java.lang.Comparable');_.$isInstance=kd;_=qc('java.lang.Double');_.$isInstance=nd;_=qc('java.lang.Number');_.$isInstance=ld;_=qc('java.lang.String');_.$isInstance=td;_=qc('java.lang.Throwable');_.of=A;_=qc('javaemul.internal.HashCodes',wd);_.getIdentityHashCode=xd;_.getNextHash=yd;_.getObjectIdentityHashCode=zd;_=qc('javaemul.internal.JsUtils');_.toDoubleFromUnsignedInt=Dd;var Ed=(L(),O);var gwtOnLoad=gwtOnLoad=kc;ic(tc);lc('permProps',[[['locale','default'],['user.agent',Qd]]]);if (demo) demo.onScriptLoad(gwtOnLoad);})();