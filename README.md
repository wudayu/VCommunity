## VCommunity
### Server
#### Environment Configuration
* Install **Java** and **Gradle** then configure the **classpath**, if you use ***inx**, you can copy the follow code and paste to your `/etc/profile`.
```bash
export JAVA_HOME=your_jdk_home
export CLASSPATH=.:$CLASSPATH:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export GRADLE_HOME=your_gradle_home
export PATH=:$PATH:$JAVA_HOME/bin:$GRADLE_HOME/bin
```
* Change directory to `~/where_you_clone_project_path` run `gradle run`.
* Install **npm**. 

Ubuntu >
```bash
sudo apt-get install npm
```
Mac OSX >
```bash
sudo brew install npm
```
* Install **Nginx**.


Ubuntu >
```bash
sudo apt-get install nginx
```
Mac OSX >
```bash
sudo brew install nginx
```
* Copy the `/server/etc/vc.conf` to `nginx/config.d/`.
* Change directory to `/project_root/client/web` run `npm install`.
* Start the nginx, then enjoy it :) !

