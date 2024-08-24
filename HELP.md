# Spring: Ambiguous Autowiring Candidates Inspection: don't highlight when @Profile is used

https://youtrack.jetbrains.com/issue/IDEA-358182

First case: same-named non-public beans; injection by type - no error
Second case: public beans with different names; injection by type  - no error
Third case: non-public beans with different names; injection by type - ERROR