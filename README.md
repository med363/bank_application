# bank_application
## insialize project
```bash
https://start.spring.io/
``` 

## principale notion 
IOC(injecteur de dependance) || inveseur de controle:fct (impliment) dans spring (mecanisme de framework ) 
application context:memoire ou location pour stockee les object pour qu'il soit disponible 
spring => framework => conteneur ==>ensemble de composant => base sur l'image jdk =>execute ensemble d'instruction pour demarre l'application
gradle et maven =>gestionnaire de dependence dans mon projet => les dependence ikouno mawjoudin en local=>gradle base sur groovy / kotlin or maven base sur xml
version snapshot==> en cours de develloppent ==> ou RC =>livre mais je  test integration est ce que biblioteque compatibe ou non 
3.0.4==> 4 c.à dire bug fix (changement mineur d'une methode ti9bil float ki tybda 3.1.0 ==> 1 c'est un nv feature(changement majeur=> methode twali ty9bil type de variable different que les type ancien ) ==> bibliotheque partage donc on besoin de versonning
release => deployement et dans le production (users use it)
project metadata==> group=>grd projet (societe) /artifact=>prjet en court =>pour l'organisation 
packaging=>qd je fait un building jar(stand allow)+ tomcat/war depend du serveur 
dependence(les starters se sont des projet spring boot et donner la possibilite d'autoconfiguration) donc add dependencies web et pour la cnnx au db =>db
openfin san3to netflix connect other application API distant
dependence test generate implicite
first : cree une application restAPI pour expose des ressources
qd telecharge dependence i5alihom fi external libraries 
extend min projet e5er fil pom.xml fiw wist les deux balisse <parent></parent>
maven gere les conflit de depence si une dependence utilis meme starter que autre dependence
lorsque on utilise intellij pas necessaire d'installer jdk sur pc(sdk)file>project structure>sdk
ay projet spring boot va utilise maven wrapper  mta3o pas necessaire d'installe maven sur pc file >setting>build,excution,deployement>build tools>maven
src>main>resources>application.proprieties(n5ali honi url username pw pour connecter au db) ere il va cherche puis il va transet vers context sinon fil application.proprieties
java reflection tbadel contenu d'une attribut private => qd les instance dans la memoire 
qt spring bloque execution qd private methode et kol objet avec getter setter ki nib3ath lil back wala n'expose donc utilise reflecletion
propriety driven =>fichier yml
spring gere cycle de vie bean =>1.precrecreate 2.oncreation 3.postcreation(objet beanpostprocessor)=> why not use @Value=> (bean) puisque mazelt masaratch il creation w ena n7ib n'exucute qlq chose 4.predestroy 5.postdestroy
postprepocessing iji bithabt mb3ad il creation(yesa3 les bean w mba3d postprocessing) 
deployement=>machine mawjoud other place =>local running sur place //thiz t'execute sur server distant/distant il faut etre accesible depuis internet avec adresse public /1.build mvnw.cmd (./mvnw clean install) =>compile tt projet puis build et on le met dans un dossier target .class(fichier compiler )2.run les test non build application ./mvnw test 3.upload sur un serveur distant donc va vers target puis on execute sur mon pc .exe ili howa .jar non sur intllij just classes non use .jar command de packaging (java -jar target/myapp-0.0.-SNAPSHOT.jar) sur intellij il suffit d'excute
dossier dans github c'est un reposotory
.idea fih config intellig
 commit==>version 
API==JPA ==ensemble de methode (regles)==tes2lni b facon parti mich njawbik
REST==architecture == standard representational procole hhttp caract non etat du session (statless) ==>expose des informatino(ressource) operation crud patch ==classification log (put/patch) ==modifie partie particulier du ress 
srv==rehgle de gestion  ,ser2== gestion system de stockage (DOA)(war9a tiktib les donnes ) hazizt'ha lil 5azna db 
bd pas tjr necessaire il suffit de system de stockage
maven gere es depences d'une application==outilsepl fil mvn repo telech-read (externellibraries sur votre pc)
servlet class <==> controller (crud) bean il va recevoir faire trait puis iraja3 reponse
POJO 
un package == dossier
les interface de marquage vide
Restcontroller cycle de vir gerre par spring controller bean
il faut .html put dans folder static
je peut controller avoir deux controller pour gestion deux client pour gestion de mes obje selon besoin
ambiguous mapping => ambiquiete ==>output ma3rafch mta3 methode 
dispatcher servlet == howa mich iwaza3 traffic inady il handle mapping ishouf table de routage mta3 spring boot (url get ==> uri unique ress id (methode + path + path variable) ilawj controllr il va executer win raj3ou il reponse lil dispatcherservlet
ide == howa compiler yesta3mil fi .class les fichie == bib au moment d'ecution il va injecte code== ismha lombok ==code fi 3oth getter w stter w constructer avec ou sans ==> but reduire code 
./mvnw iU (telecharge dependence)==> mettre a jour projet
builder construi des objet ma3ndouch constructor methode builder ==> simplifier creation des objets =>response body transformer objet en objet json ==produces form de transformation 
design pattern ==> IOC ,MVC..==>categorie de creation idolation de code relative a la creation ala initialisation a fin de rendre l'application independente de ses aspect ==> un exple de design pattern de creation factory , abstract factory ,builder ,prototype et singletemps 
les design pattern de structure ==>desc de la maniere dont doivent etre connecter ds objects a l'application afin de rendre ses connections indepents des evolutin futture de l'application par exple le design patern adapter ,composite , bridge , decorateur et proxy .
design pattern de comportement description de l'interaction entre les objects ,permet la gestion dynamique entre les classes et les objects par exple le design pattern strategy ,observateur et iterateur et mediateur et state.
==>porte design pattern : porte de class ==> focalisation entr e class et sous class // et la rutilisation par heritage ///portee d'instance ou porte d'objet focalisation la relation entre les objects et la reutilisation par composition 
design pattern proxy ==>fournir un acces controllzer a une fonctionalite == une class proxy fournit un acces controller au programmes 
JPA interface => hebernate leur implimentation (oopenClose)
interface => contrat de service content yetbadel 

class responsablz au manipulation data reposotory
stream sequence d'object => capplique a3lih ensemble de methode (operation _filter -transformation (map:hotto fi container w finallement collect(methode de redirection (findfirst /orelse)
ractif programming ==> no load ili ya7dhar nib3zth communcation with base d'une façon reactive
hibernate se bzse sur id (save) fil table sinon mafamech insert sinon 9aha ya3mlilha modification
spring profils dev(postegres)-prod(oracale) applique selon profil ili 7il override on cree fichier application.yml
==> pour que mon application soit flexiele
command:1.mvnw clean install =>.jar mon application final
2.cd target jar -jar  -Dspring.profiles.active=<nom_profiles> <nom>.jar
or creat file =>.yml spring: profiles:  active: app
@Entity pour dire c'esrt un table dans bd et @Table(name= "_user")
par defaut 0-1 relation unidercti/biderectionnel =>indexation 
@JoinCloumn(name="") ism cle etrnahger wala tab de jointure ana a3tit o ism mabin deux table
@ManyToMANY YESNA3 TABLE DE JOINTURE AUTOMATIQUE
on bvesion de v l'interface si on a extentionn de mn proje
t  niveau de securite pour non expose table solution pour que mon api resteen local pour faire account (iban et un objet user)
0 to many mapped appartient seiul user user list de transact w kol trans ib3ath'ha seul usl user hebernat pour id relation cote one to mapping attribue fil class 3ibaratan delegee fil tab ili ana 9olt relation many
objet de transfert objet reposAccont lil account entity avec builder
mapper ou mapping transformation des objects
mapping c'est une get/set
class qui perme de valid ls objet de java
factory design patern fih tout les validator
class generique <T exends Serializable>: type yetbadel minj objet lil objet limit les cless ili estends mi n class Serialiseble (hya interface mafiha chy ) malge interface extends or il faut dans le cas nrmal impliments

check exption en mode veif au monent complation  (d'ecriture code)(extends exception)
incheck exception au cours d'exetion du programme
commandlineRunner execute au moment de demarrage de la pp c'est une bean et on injecte les bean qu'on va excute
gestionna	ire d'exceptino => exception handler lin tarja3 lil ciontroller stack trace kol matsyr exception howa yabsorbiha => intercepte man7ibich lil user final man7ybich nraja3lo exception de mon system.
