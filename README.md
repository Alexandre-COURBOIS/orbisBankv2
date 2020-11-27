
                                                            Initializing
                                                            
1) Start by cloning the project
2) Initialize the java file in the project a directory source root.
3) add resources files as a ressource root.
4) Get database schema at : https://we.tl/t-9eYOEyZUer create her and restore.
5) create à JdbcDao with your own postgres ID and your database Name: 

        package com.orbisbank.dao.impl;
    
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
    
        public class JdbcDao {
    
            private static final String URL="jdbc:postgresql://127.0.0.1/NOM DE LA BDD SUR POSTGRES";
            private static final String USER="VOTRE NOM D'UTILISATEUR (postgres par defaut)";
            private static final String PASS="VOTRE MOT DE PASSE";
        
            private final Connection connection;
        
            public JdbcDao() throws SQLException{
                this.connection = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("connected to database");
            }
        
            protected Connection getConnection(){
                return this.connection;
            } 
        }

6) add the file config.properties in ressources/properties with your smtp login : 

        ####### LOGS GOOGLE ORBISBANK #########
        orbisbank.login=SmtpLogin
        orbisbank.password=SmtpPassword
  
7) Click right on your name project and Rebuild the module.

8) Try it ! And tell us what you think about it ! 

Personnal informations :

                                                         Our organization
                                                          
                                            JAPIWEB creator of website & .exe application
                                        
                                                 All right reserved ©JAPIWEB & ©OrbisBank
