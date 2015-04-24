#gitflow  
(version 0.4.1)

## Initialize

### git flow init [-fd]
**-d** use default branch names

**-f** force

Initialize a new git repo with support for the branching model.

## Feature

### git flow feature [list] [-v]

**-v** verbose (more) output

Lists existing features

### git flow feature start [-F] \<name> [\<base>]
**-F** fetch from $ORIGIN before performing local operation

Start new feature _\<name>_, optionally basing it on _\<base>_ instead of _\<develop>_

### git flow feature finish [-rFk] \<name|nameprefix>
**-r** rebase instead of merge

**-F** fetch from $ORIGIN before performing finish

**-k** keep branch after performing finish

Finish feature _\<name>_

### git flow feature publish \<name>

Start sharing feature _\<name>_ on $ORIGIN

### git flow feature track \<name>

Start tracking feature _\<name>_ that is shared on $ORIGIN

### git flow feature diff [\<name|nameprefix>]

Show all changes in _\<name>_ that are not in _\<develop>_

### git flow feature rebase [-i] [\<name|nameprefix>]

**-i** do an interactive rebase

Rebase _\<name>_ on _\<develop>_

### git flow feature checkout [\<name|nameprefix>]

Switch to feature branch _\<name>_

### git flow feature pull \<remote> [\<name>]

Pull feature _\<name>_ from _\<remote>_

## Release

### git flow release [list] [-v]
**-v** verbose (more) output

Lists existing releases

### git flow release start [-F] \<version>
**-F** fetch from $ORIGIN before performing local operation

Start new release named _\<version>_

### git flow release finish [-Fsumpkn] \<version>
**-F** fetch from $ORIGIN before performing finish

**-s** sign the release tag cryptographically

**-u** use the given GPG-key for the digital signature (implies -s)

**-m** use the given tag message

**-p** push to $ORIGIN after performing finish

**-k** keep branch after performing finish

**-n** don't tag this release


Finish release _\<version>_

### git flow release publish \<name>
Start sharing release _\<name>_ on $ORIGIN

### git flow release track \<name>
Start tracking release _\<name>_ that is shared on $ORIGIN

## Hotfix
### git flow hotfix [list] [-v]
**-v** verbose (more) output

Lists existing hotfixes
### git flow hotfix start [-F] \<version> [\<base>]
**-F** fetch from $ORIGIN before performing local operation

Start new hotfix named _\<version>_, optionally base it on _\<base>_ instead of _\<master>_
### git flow hotfix finish [-Fsumpkn] \<version>
**-F** fetch from $ORIGIN before performing finish

**-s** sign the release tag cryptographically

**-u** use the given GPG-key for the digital signature (implies -s)

**-m** use the given tag message

**-p** push to $ORIGIN after performing finish

**-k** keep branch after performing finish

**-n** don't tag this release


Finish hotfix _\<version>_

## Support
### git flow support [list] [-v]
**-v** verbose (more) output

Lists existing support branches
### git flow support start [-F] \<version> \<base>
**-F** fetch from $ORIGIN before performing local operation

Start new support branch named _\<version>_ based on _\<base>_

## Configuration

### Setting a different remote repo
A remote repo different from _origin_ can be specified in the config file:

`$ git config gitflow.origin myorigin`

### Default to fetching before local operations
If you always want to fetch from $ORIGIN before certain operations, for example before starting a feature:

`$ git config gitflow.feature.start.fetch true`

This can still be overridden on the command line by supplying the **--nofetch** argument.